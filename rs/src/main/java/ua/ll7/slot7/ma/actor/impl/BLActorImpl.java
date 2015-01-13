package ua.ll7.slot7.ma.actor.impl;

import akka.actor.TypedActor;
import org.joda.money.CurrencyUnit;
import org.springframework.beans.factory.annotation.Autowired;
import ua.ll7.slot7.ma.actor.IBLActor;
import ua.ll7.slot7.ma.data.request.*;
import ua.ll7.slot7.ma.data.vo.ExpenseVO;
import ua.ll7.slot7.ma.data.vo.UserVO;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.Expense;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.IBLService;

import java.util.List;

/**
 * @author velichko
 *         on 12.01.15 : 15:13
 */
public class BLActorImpl extends TypedActor implements IBLActor {

  @Autowired
  private IBLService blService;

  @Override
  public void userCreate(String email, String password) {
    blService.userCreate(email, password);
  }

  @Override
  public List<UserVO> userList() {
    return blService.userList();
  }

  @Override
  public List<UserVO> userListPageable(UserListPageableRequest request) {
    return blService.userListPageable(request);
  }

  @Override
  public CategoryForTheUser categoryCreateForUser(User user, String categoryName, String categoryDescription) {
    return blService.categoryCreateForUser(user, categoryName, categoryDescription);
  }

  @Override
  public List<CategoryForTheUser> categoryListForTheUser(User user) {
    return blService.categoryListForTheUser(user);
  }

  @Override
  public void categoryUpdate(CategoryUpdateRequest request) {
    blService.categoryUpdate(request);
  }

  @Override
  public boolean isCategoryBelongToTheUser(CategoryForTheUser category, User user) {
    return blService.isCategoryBelongToTheUser(category, user);
  }

  @Override
  public Expense expenseCreateForCategory(CategoryForTheUser category, CurrencyUnit currencyUnit, float amount, String dateSign) {
    return blService.expenseCreateForCategory(category, currencyUnit, amount, dateSign);
  }

  @Override
  public Expense expenseCreateForCategoryUSD(CategoryForTheUser category, float amount, String dateSign) {
    return blService.expenseCreateForCategoryUSD(category, amount, dateSign);
  }

  @Override
  public Expense expenseCreateForCategoryUSD(ExpenseCreateRequest request) {
    return blService.expenseCreateForCategoryUSD(request);
  }

  @Override
  public List<ExpenseVO> expenseList(ExpenseListPageableRequest request) {
    return blService.expenseList(request);
  }

  @Override
  public void currensyRateCreate(CurrensyRateCreateRequest request) {
    blService.currensyRateCreate(request);
  }

  @Override
  public float currensyRateCurrent(CurrencyRateCurrentRequest request) {
    return blService.currensyRateCurrent(request);
  }
}
