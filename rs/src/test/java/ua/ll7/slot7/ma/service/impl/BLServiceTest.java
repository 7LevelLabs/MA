package ua.ll7.slot7.ma.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.exception.AppDataIntegrityException;
import ua.ll7.slot7.ma.helper.ICategoryHelper;
import ua.ll7.slot7.ma.helper.IUserHelper;
import ua.ll7.slot7.ma.model.Category;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.IBLService;
import ua.ll7.slot7.ma.service.ICategoryService;
import ua.ll7.slot7.ma.service.IUserService;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigIT.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BLServiceTest extends Assert {

	@Autowired
	private IBLService blService;

	@Autowired
	private IUserService userService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IUserHelper userHelper;

	@Autowired
	private ICategoryHelper categoryHelper;

	@Test(expected = AppDataIntegrityException.class)
	public void testCategoryCreateException() throws Exception {
		User user = userHelper.getNewUser("email", "nick", "name", "password");
		userService.create(user);

		Category category1 = categoryHelper.getNewCategory(user, "Cat1", "Category1");
		Category category2 = categoryHelper.getNewCategory(user, "Cat2", "Category2");

		categoryService.create(category1);
		categoryService.create(category2);
		userService.update(user);

		blService.categoryCreate(user.getId(),"Cat1", "Category1");

	}

	@Test
	public void testCategoryCreate() throws Exception {
		User user = userHelper.getNewUser("email", "nick", "name", "password");
		userService.create(user);

		Category category1 = categoryHelper.getNewCategory(user, "Cat1", "Category1");
		Category category2 = categoryHelper.getNewCategory(user, "Cat2", "Category2");

		categoryService.create(category1);
		categoryService.create(category2);
		userService.update(user);

		blService.categoryCreate(user.getId(),"Cat3", "Category1");

		User userRead = userService.findByEMail("email");

		Set<Category> categorySet = userRead.getCategories();

		System.out.println(userRead);

		org.assertj.core.api.Assertions.assertThat(categorySet)
			.isNotEmpty()
			.hasSize(3)
			.contains(category1, category2)
		;

	}


}