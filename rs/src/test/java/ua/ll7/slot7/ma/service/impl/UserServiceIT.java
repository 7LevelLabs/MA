package ua.ll7.slot7.ma.service.impl;

import org.junit.Assert;
import org.junit.Ignore;
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

	@Test
	public void testFindByEMailUser() throws Exception {
		User user = MAFactory.getNewUser("email", "nick", "name", "password");
		userService.save(user);

		User user1 = MAFactory.getNewUser("email1", "nick", "name", "password");
		userService.save(user1);

		User userRead = userService.findByEMail("email");
		assertEquals(user, userRead);
	}

	@Test
	public void testUpdateUser() {
		User user = MAFactory.getNewUser("email", "nick", "name", "password");
		userService.save(user);

		user.setApiCode("New API");

		User userRead = userService.findByEMail("email");

		assertEquals(userRead.getApiCode(), "New API");
	}
}