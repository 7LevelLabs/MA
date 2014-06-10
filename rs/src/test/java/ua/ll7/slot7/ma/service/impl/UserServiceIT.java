package ua.ll7.slot7.ma.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.helper.IUserHelper;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigIT.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UserServiceIT extends Assert {

	@Autowired
	private IUserService userService;

	@Autowired
	private IUserHelper userHelper;

	@Test
	public void testFindByEMailUser() throws Exception {
		User user = userHelper.getNewUser("email", "nick", "name", "password", "apiCode");
		userService.create(user);
		User userRead = userService.findByEMail("email");
		assertEquals(user,userRead);
	}
}