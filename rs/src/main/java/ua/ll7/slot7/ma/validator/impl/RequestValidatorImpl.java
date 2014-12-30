package ua.ll7.slot7.ma.validator.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.data.request.CategoryCreateRequest;
import ua.ll7.slot7.ma.data.request.CategoryUpdateRequest;
import ua.ll7.slot7.ma.data.request.ExpenseCreateRequest;
import ua.ll7.slot7.ma.data.request.UserRegisterRequest;
import ua.ll7.slot7.ma.exception.AppValidationException;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.IBLService;
import ua.ll7.slot7.ma.service.ICategoryService;
import ua.ll7.slot7.ma.service.IUserService;
import ua.ll7.slot7.ma.validator.IRequestValidator;
import ua.ll7.slot7.ma.validator.annotations.StringDGNotEmpty;
import ua.ll7.slot7.ma.validator.annotations.StringStringDGBothNotEmpty;

/**
 * MA
 * Velichko A.
 * 26.12.14 17:47
 */
@Component
public class RequestValidatorImpl implements IRequestValidator {

  @Autowired
  private IUserService userService;

  @Autowired
  private ICategoryService categoryService;

  @Autowired
  private IBLService blService;

  @StringStringDGBothNotEmpty
  @Override
  public void validate(UserRegisterRequest request) throws AppValidationException {
    if (userService.exist(request.getData1())) {
      throw new AppValidationException("User already exists : " + request);
    }
  }

  @StringDGNotEmpty
  @Override
  public void validate(CategoryCreateRequest request, User user) throws AppValidationException {
    if (categoryService.existCategoryByName(user, request.getData1())) {
      throw new AppValidationException("User already exists : " + request);
    }
  }

  @Override
  public void validate(CategoryUpdateRequest request) throws AppValidationException {
    if ((StringUtils.isBlank(request.getData1())) && (StringUtils.isBlank(request.getData2()))) {
      throw new AppValidationException("Not valid request : " + request);
    }

    if (!categoryService.exist(request.getData3())) {
      throw new AppValidationException("Category is not exist : " + request);
    }
  }

  @Override
  public void validate(ExpenseCreateRequest request, User user) throws AppValidationException {
    //TODO implement

    //check currency sign

    //check date sign

    //check category

  }
}
