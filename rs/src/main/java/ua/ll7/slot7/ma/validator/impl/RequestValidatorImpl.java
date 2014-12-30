package ua.ll7.slot7.ma.validator.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.data.Constants;
import ua.ll7.slot7.ma.data.request.CategoryCreateRequest;
import ua.ll7.slot7.ma.data.request.CategoryUpdateRequest;
import ua.ll7.slot7.ma.data.request.ExpenseCreateRequest;
import ua.ll7.slot7.ma.data.request.UserRegisterRequest;
import ua.ll7.slot7.ma.exception.AppDataIntegrityException;
import ua.ll7.slot7.ma.exception.AppValidationException;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.IBLService;
import ua.ll7.slot7.ma.service.ICategoryService;
import ua.ll7.slot7.ma.service.IUserService;
import ua.ll7.slot7.ma.validator.IRequestValidator;
import ua.ll7.slot7.ma.validator.annotations.StringDGNotEmpty;
import ua.ll7.slot7.ma.validator.annotations.StringStringDGBothNotEmpty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	public void validate(ExpenseCreateRequest request, User user) throws AppValidationException, AppDataIntegrityException {
		//check category - is it belongs to the user?
		if (!blService.isCategoryBelongToTheUser(categoryService.findById(request.getData0()), user)) {
			throw new AppDataIntegrityException("The category is not belongs to the user : " + request);
		}

		//check date sign
		if (StringUtils.isBlank(request.getData1())) {
			throw new AppValidationException("Activity date must be not empty : " + request);
		}

		SimpleDateFormat formatter = new SimpleDateFormat(Constants.dateFormatString);
		Date actionDate;

		try {
			actionDate = formatter.parse(request.getData1());
		} catch (ParseException ignore) {
			throw new AppValidationException("Activity date sign must be formatted as follows : "
													 + Constants.divider
													 + request.getData1()
													 + Constants.divider
													 + request);
		}

		//check currency amount
		if (request.getData3() == 0) {
			throw new AppValidationException("Expense amount must be > 0 : " + request);
		}
	}
}
