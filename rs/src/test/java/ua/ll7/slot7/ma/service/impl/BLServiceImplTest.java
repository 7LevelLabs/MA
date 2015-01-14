package ua.ll7.slot7.ma.service.impl;

import org.joda.money.CurrencyUnit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.data.request.UserListPageableRequest;
import ua.ll7.slot7.ma.data.request.UserRegisterRequest;
import ua.ll7.slot7.ma.data.vo.UserVO;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.Expense;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.IBLService;
import ua.ll7.slot7.ma.service.ICategoryService;
import ua.ll7.slot7.ma.service.IUserService;
import ua.ll7.slot7.ma.util.MAFactory;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:maTestConf/maConfigTest.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BLServiceImplTest extends Assert {

  @Autowired
  private IBLService blService;

  @Autowired
  private IUserService userService;

  @Autowired
  private ICategoryService categoryService;

  @Test
  public void testUserCreate() {
    UserRegisterRequest request = new UserRegisterRequest();
    request.setData1("test@test.com");
    request.setData2("testPasswd");

    blService.userCreate(request);

    User userRead = userService.findByEMail("test@test.com");
    assertEquals(userRead.getEmail(), "test@test.com");
  }

  @Test
  public void testUserList() throws Exception {
    User user1 = MAFactory.getNewUserForTestsFS("email1", "nick1", "name1", "password1");
    userService.save(user1);

    User user2 = MAFactory.getNewUserForTestsFS("email2", "nick2", "name2", "password2");
    userService.save(user2);

    List<UserVO> userVOs = blService.userList();

    org.assertj.core.api.Assertions.assertThat(userVOs)
                         .isNotEmpty()
                         .hasSize(2);

  }

  @Test
  public void testUserListPageable() throws Exception {
    User user1 = MAFactory.getNewUserForTestsFS("email1", "nick1", "name1", "password1");
    userService.save(user1);

    User user2 = MAFactory.getNewUserForTestsFS("email2", "nick2", "name2", "password2");
    userService.save(user2);

    User user3 = MAFactory.getNewUserForTestsFS("email3", "nick3", "name3", "password3");
    userService.save(user3);

    User user4 = MAFactory.getNewUserForTestsFS("email4", "nick4", "name4", "password4");
    userService.save(user4);

    UserListPageableRequest request = new UserListPageableRequest();
    request.setData1(1);
    request.setData2(3);

    List<UserVO> userVOs = blService.userListPageable(request);

    org.assertj.core.api.Assertions.assertThat(userVOs)
                         .isNotEmpty()
                         .hasSize(3);

    request.setData1(2);
    request.setData2(3);

    userVOs = blService.userListPageable(request);

    org.assertj.core.api.Assertions.assertThat(userVOs)
                         .isNotEmpty()
                         .hasSize(1);
  }

  @Test
  public void testCategoryCreate() throws Exception {
    User user = MAFactory.getNewUserForTestsFS("email", "nick", "name", "password");
    userService.save(user);

    CategoryForTheUser categoryForTheUser1 = MAFactory.getNewCategoryFS(user, "Cat1", "Category1");
    CategoryForTheUser categoryForTheUser2 = MAFactory.getNewCategoryFS(user, "Cat2", "Category2");

    categoryService.save(categoryForTheUser1);
    categoryService.save(categoryForTheUser2);

    blService.categoryCreateForUser(user, "Cat3", "Category1");

    User userRead = userService.findByEMail("email");

    List<CategoryForTheUser> categoryForTheUserList = userRead.getCategories();

    org.assertj.core.api.Assertions.assertThat(categoryForTheUserList)
                                   .isNotEmpty()
                                   .hasSize(3)
                                   .contains(categoryForTheUser1, categoryForTheUser2)
    ;

  }

  @Test
  public void testExpenseCreateForCategory() throws Exception {
    User user = MAFactory.getNewUserForTestsFS("email", "nick", "name", "password");
    userService.save(user);

    CategoryForTheUser categoryForTheUser = blService.categoryCreateForUser(user, "Cat3", "Category1");

    Expense expense = blService.expenseCreateForCategory(categoryForTheUser, CurrencyUnit.USD, 10.01F, "10-12-2015");

    assertTrue(expense.getCategoryForTheUser().getName().equals("Cat3") &&
                 expense.getCategoryForTheUser().getId() > 0);
  }

  @Test
  public void testCategoryListForTheUser() throws Exception {
    User user = MAFactory.getNewUserForTestsFS("email", "nick", "name", "password");
    userService.save(user);

    CategoryForTheUser categoryForTheUser1 = blService.categoryCreateForUser(user, "Cat1", "Category1");
    CategoryForTheUser categoryForTheUser2 = blService.categoryCreateForUser(user, "Cat2", "Category2");

    User userRead = userService.findByEMail("email");

    List<CategoryForTheUser> categoryForTheUsers = blService.categoryListForTheUser(userRead);

    org.assertj.core.api.Assertions.assertThat(categoryForTheUsers)
                                   .isNotEmpty()
                                   .hasSize(2)
                                   .contains(categoryForTheUser1, categoryForTheUser2)
    ;
  }
}