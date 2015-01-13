package ua.ll7.slot7.ma.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.joda.money.CurrencyUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.data.request.*;
import ua.ll7.slot7.ma.data.vo.ExpenseVO;
import ua.ll7.slot7.ma.data.vo.UserVO;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.Expense;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.*;
import ua.ll7.slot7.ma.util.MAFactory;
import ua.ll7.slot7.ma.util.builder.ExpenseBuilder;

import java.util.List;

/**
 * @author Alex Velichko
 *         10.06.14 : 15:27
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class BLServiceImpl implements IBLService {

  private static final Logger LOGGER = Logger.getLogger(BLServiceImpl.class);

  @Autowired
  private IUserService userService;

  @Autowired
  private ICategoryService categoryService;

  @Autowired
  private IExpenseService expenseService;

  @Autowired
  private ICurrencyRateService currencyRateService;

  @Override
  public void userCreate(UserRegisterRequest request) {
    User user = new User();
    user.setEmail(request.getData1());
    user.setPassword(request.getData2());
    userService.save(user);

    //TODO send emails
  }

  @Override
  public List<UserVO> userList() {
    return MAFactory.getUserVOList(userService.findAll());
  }

  @Override
  public List<UserVO> userListPageable(UserListPageableRequest request) {
    return MAFactory.getUserVOList(userService.findAllPageable(request.getData1(),
                                                               request.getData2()));
  }

  @Override
  public CategoryForTheUser categoryCreateForUser(User user, String categoryName, String categoryDescription) {
    CategoryForTheUser categoryForTheUser = MAFactory.getNewCategoryFS(user,
                                                                       categoryName,
                                                                       categoryDescription);

    categoryService.save(categoryForTheUser);

    return categoryForTheUser;
  }

  @Override
  public List<CategoryForTheUser> categoryListForTheUser(User user) {
    return categoryService.findByUser(user);
  }

  @Override
  public void categoryUpdate(CategoryUpdateRequest request) {
    CategoryForTheUser categoryForTheUser = categoryService.findById(request.getData3());

    if (StringUtils.isNotBlank(request.getData1())) {
      categoryForTheUser.setName(request.getData1());
    }

    if (StringUtils.isNotBlank(request.getData2())) {
      categoryForTheUser.setName(request.getData2());
    }
  }

  @Override
  public boolean isCategoryBelongToTheUser(CategoryForTheUser category, User user) {
    return userService.findById(category.getUser().getId()).equals(user);
  }

  @Override
  public Expense expenseCreateForCategory(CategoryForTheUser category, CurrencyUnit currencyUnit, float amount, String dateSign) {
    Expense result = new ExpenseBuilder(category, amount)
           .withActionDateSign(dateSign)
           .withAmount(currencyUnit, amount)
           .build();
    expenseService.save(result);
    return result;
  }

  @Override
  public Expense expenseCreateForCategoryUSD(CategoryForTheUser category, float amount, String dateSign) {
    return expenseCreateForCategory(category, CurrencyUnit.USD, amount, dateSign);
  }

  @Override
  public Expense expenseCreateForCategoryUSD(ExpenseCreateRequest request) {
    return expenseCreateForCategoryUSD(categoryService.findById(request.getData0()),
                                       request.getData3(),
                                       request.getData1());
  }

  @Override
  public List<ExpenseVO> expenseList(ExpenseListPageableRequest request) {
    return MAFactory.getExpenseVOList(expenseService.findByCategoryPageable(
           categoryService.findById(request.getData3()),
           request.getData1(),
           request.getData2()
    ));
  }

  @Override
  public void currensyRateCreate(CurrensyRateCreateRequest request) {
    currencyRateService.save(MAFactory.getNewCurrencyRateFS(request.getData1(),
                                                            request.getData2(),
                                                            request.getData3()));
  }

  @Override
  public float currensyRateCurrent(CurrencyRateCurrentRequest request) {
    return currencyRateService.getCurrentCurrencyRate(request.getData1(), request.getData2()).getRate();
  }
}
