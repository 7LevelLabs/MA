package ua.ll7.slot7.ma.validator;

import ua.ll7.slot7.ma.data.request.*;
import ua.ll7.slot7.ma.exception.AppDataIntegrityException;
import ua.ll7.slot7.ma.exception.AppValidationException;
import ua.ll7.slot7.ma.model.User;

/**
 * MA
 * Velichko A.
 * 26.12.14 17:52
 */
public interface IRequestValidator {

  public void validate(UserListPageableRequest request) throws AppValidationException;

  public void validate(UserRegisterRequest request) throws AppValidationException;

  public void validate(UserSetActiveRequest request) throws AppValidationException;

  public void validate(CategoryCreateRequest request, User user) throws AppValidationException;

  public void validate(CategoryUpdateRequest request) throws AppValidationException;

  public void validate(ExpenseCreateRequest request, User user) throws AppValidationException, AppDataIntegrityException;

  public void validate(ExpenseListPageableRequest request, User user) throws AppValidationException, AppDataIntegrityException;

  public void validate(CurrensyRateCreateRequest request) throws AppValidationException;

  public void validate(CurrencyRateCurrentRequest request) throws AppValidationException;
}
