package ua.ll7.slot7.ma.validator;

import ua.ll7.slot7.ma.data.request.UserRegisterRequest;
import ua.ll7.slot7.ma.exception.AppValidationException;

/**
 * MA
 * Velichko A.
 * 26.12.14 17:52
 */
public interface IRequestValidator {
  public void validate(UserRegisterRequest request) throws AppValidationException;
}
