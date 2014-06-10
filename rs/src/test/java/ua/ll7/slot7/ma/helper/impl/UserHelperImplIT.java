package ua.ll7.slot7.ma.helper.impl;

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
import ua.ll7.slot7.ma.model.Category;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.ICategoryService;
import ua.ll7.slot7.ma.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigIT.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UserHelperImplIT extends Assert {

	@Autowired
	private IUserService userService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IUserHelper userHelper;

	@Autowired
	private ICategoryHelper categoryHelper;

	@Test
	public void testExistCategoryByName() throws Exception {
		User user = userHelper.getNewUser("email", "nick", "name", "password");

		Category category1 = categoryHelper.getNewCategory(user, "Cat1", "Category1");
		Category category2 = categoryHelper.getNewCategory(user, "Cat2", "Category2");

		assertTrue(userHelper.existCategoryByName(user,"Cat1"));
		assertFalse(userHelper.existCategoryByName(user,"Cat3"));
	}
}