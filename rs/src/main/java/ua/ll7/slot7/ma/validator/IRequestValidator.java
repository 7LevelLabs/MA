package ua.ll7.slot7.ma.validator;

import ua.ll7.slot7.ma.data.request.CategoryCreateRequest;
import ua.ll7.slot7.ma.data.request.CategoryUpdateRequest;
import ua.ll7.slot7.ma.data.request.ExpenseCreateRequest;
import ua.ll7.slot7.ma.data.request.UserRegisterRequest;
import ua.ll7.slot7.ma.exception.AppDataIntegrityException;
import ua.ll7.slot7.ma.exception.AppValidationException;
import ua.ll7.slot7.ma.model.User;

/**
 * MA
 * Velichko A.
 * 26.12.14 17:52
 */
public interface IRequestValidator {
	public void validate(UserRegisterRequest request) throws AppValidationException;

	public void validate(CategoryCreateRequest request, User user) throws AppValidationException;

	public void validate(CategoryUpdateRequest request) throws AppValidationException;

	public void validate(ExpenseCreateRequest request, User user) throws AppValidationException, AppDataIntegrityException;
}
