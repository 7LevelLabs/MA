package ua.ll7.slot7.ma.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.helper.ICategoryHelper;
import ua.ll7.slot7.ma.helper.IUserHelper;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.ICategoryService;
import ua.ll7.slot7.ma.service.IUserService;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigIT.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UserServiceIT extends Assert {

	@Autowired
	private IUserService userService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IUserHelper userHelper;

	@Autowired
	private ICategoryHelper categoryHelper;

	@Test
	public void testFindByEMailUser() throws Exception {
		User user = userHelper.getNewUser("email", "nick", "name", "password");
		userService.create(user);
		User userRead = userService.findByEMail("email");
		assertEquals(user, userRead);
	}

	@Test
	public void testUpdateUser() {
		User user = userHelper.getNewUser("email", "nick", "name", "password");
		userService.create(user);

		CategoryForTheUser categoryForTheUser1 = categoryHelper.getNewCategory(user, "Cat1", "Category1");
		CategoryForTheUser categoryForTheUser2 = categoryHelper.getNewCategory(user, "Cat2", "Category2");

		categoryService.create(categoryForTheUser1);
		categoryService.create(categoryForTheUser2);

		userService.update(user);

		User userRead = userService.findByEMail("email");

		Set<CategoryForTheUser> categoryForTheUserSet = userRead.getCategories();

		CategoryForTheUser categoryForTheUser3 = new CategoryForTheUser();
		categoryForTheUser3.setUser(user);
		categoryForTheUser3.setName("Cat3");

		org.assertj.core.api.Assertions.assertThat(categoryForTheUserSet)
			.isNotEmpty()
			.hasSize(2)
			.contains(categoryForTheUser1, categoryForTheUser2)
			.doesNotContain(categoryForTheUser3);
	}
}