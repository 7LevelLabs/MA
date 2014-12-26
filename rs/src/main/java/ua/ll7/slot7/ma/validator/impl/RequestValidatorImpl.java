package ua.ll7.slot7.ma.validator.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.data.request.UserRegisterRequest;
import ua.ll7.slot7.ma.exception.AppValidationException;
import ua.ll7.slot7.ma.service.IUserService;
import ua.ll7.slot7.ma.validator.IRequestValidator;

/**
 * MA
 * Velichko A.
 * 26.12.14 17:47
 */
@Component
public class RequestValidatorImpl implements IRequestValidator {

  @Autowired
  private IUserService userService;

  public void validate(UserRegisterRequest request) throws AppValidationException {
    if (StringUtils.isBlank(request.getData1()) || (StringUtils.isBlank(request.getData1()))) {
      throw new AppValidationException("Not valid UserRegisterRequest : " + request);
    }
    if (userService.exist(request.getData1())) {
      throw new AppValidationException("User already exists : " + request);
    }
  }

}
