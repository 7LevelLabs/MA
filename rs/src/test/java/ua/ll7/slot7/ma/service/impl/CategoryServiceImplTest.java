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

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigIT.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class CategoryServiceImplTest {

  @Autowired
  private IUserService userService;

  @Autowired
  private ICategoryService categoryService;

  @Test
  public void testExistCategoryByName() throws Exception {
    User user = MAFactory.getNewUserForTestsFS("email", "nick", "name", "password");
    userService.save(user);

    CategoryForTheUser categoryForTheUser1 = MAFactory.getNewCategoryFS(user, "Cat1", "Category1");
    categoryService.save(categoryForTheUser1);

    User userRead = userService.findByEMail("email");

    boolean categoryExist = categoryService.existCategoryByName(userRead, "Cat1");
    assertTrue(categoryExist);

    categoryExist = categoryService.existCategoryByName(userRead, "Cat2");
    assertFalse(categoryExist);
  }

  @Test
  public void testFindByUserAndName() throws Exception {
    User user = MAFactory.getNewUserForTestsFS("email", "nick", "name", "password");
    userService.save(user);

    CategoryForTheUser categoryForTheUser1 = MAFactory.getNewCategoryFS(user, "Cat1", "Category1");
    CategoryForTheUser categoryForTheUser2 = MAFactory.getNewCategoryFS(user, "Cat2", "Category1");
    categoryService.save(categoryForTheUser1);
    categoryService.save(categoryForTheUser2);

    User userRead = userService.findByEMail("email");

    CategoryForTheUser categoryRead = categoryService.findByUserAndName(userRead, "Cat2");

    assertEquals(categoryRead.getName(), "Cat2");
  }
}