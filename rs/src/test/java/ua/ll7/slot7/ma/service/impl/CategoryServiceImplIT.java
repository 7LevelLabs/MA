package ua.ll7.slot7.ma.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.ICategoryService;
import ua.ll7.slot7.ma.service.IUserService;
import ua.ll7.slot7.ma.util.MAFactory;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:maTestConf/maConfigIT.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class CategoryServiceImplIT {

	@Autowired
	private IUserService userService;

	@Autowired
	private ICategoryService categoryService;

	@Test
	public void testFindPopularNames() throws Exception {
		User user = MAFactory.getNewUserForTestsFS("email", "nick", "name", "password");
		userService.save(user);

		CategoryForTheUser categoryForTheUser1 = MAFactory.getNewCategoryFS(user, "Cat1", "Category1");
		categoryService.save(categoryForTheUser1);

		CategoryForTheUser categoryForTheUser2 = MAFactory.getNewCategoryFS(user, "Cat2", "Category1");
		categoryService.save(categoryForTheUser2);

		CategoryForTheUser categoryForTheUser3 = MAFactory.getNewCategoryFS(user, "Cat2", "Category1");
		categoryService.save(categoryForTheUser3);

		CategoryForTheUser categoryForTheUser4 = MAFactory.getNewCategoryFS(user, "Cat4", "Category1");
		categoryService.save(categoryForTheUser4);

		List<String> names = categoryService.findPopularNames(1);

		org.assertj.core.api.Assertions.assertThat(names)
												 .isNotEmpty()
												 .hasSize(1)
												 .contains("Cat2")
		;

	}
}