package ua.ll7.slot7.ma.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.IUserService;
import ua.ll7.slot7.ma.util.creators.UserBuilder;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:maTestConf/maConfigIT.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UserServiceImplTestIT {

  @Autowired
  private IUserService userService;

  @Test
  public void testCaching() throws Exception {
    User user1 = new UserBuilder("test1@test.com", "pass1").build();
    User user2 = new UserBuilder("test2@test.com", "pass2").build();
    User user3 = new UserBuilder("test3@test.com", "pass3").build();

    userService.save(user1);
    userService.save(user2);
    userService.save(user3);

    User userRead1 = userService.findByEMail("test1@test.com");

    long usf1 = System.currentTimeMillis();

    User userRead2 = userService.findByEMail("test2@test.com");

    long usf2 = System.currentTimeMillis();

    User userRead3 = userService.findByEMail("test3@test.com");

    long usf3 = System.currentTimeMillis();

    userRead1 = userService.findByEMail("test1@test.com");

    long ur1 = System.currentTimeMillis();

    userRead2 = userService.findByEMail("test2@test.com");

    long ur2 = System.currentTimeMillis();

    userRead3 = userService.findByEMail("test3@test.com");

    long ur3 = System.currentTimeMillis();

    assertTrue((ur2 - ur1) < (usf2 - usf1));
    assertTrue((ur3 - ur2) < (usf3 - usf2));

  }

}