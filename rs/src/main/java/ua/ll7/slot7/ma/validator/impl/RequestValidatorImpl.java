package ua.ll7.slot7.ma.validator.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.data.Constants;
import ua.ll7.slot7.ma.data.request.*;
import ua.ll7.slot7.ma.exception.AppDataIntegrityException;
import ua.ll7.slot7.ma.exception.AppValidationException;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.IBLService;
import ua.ll7.slot7.ma.service.ICategoryService;
import ua.ll7.slot7.ma.service.IUserService;
import ua.ll7.slot7.ma.validator.IRequestValidator;
import ua.ll7.slot7.ma.validator.annotations.IntIntDGBothNotEmpty;
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

    @IntIntDGBothNotEmpty
    @Override
    public void validate(UserListPageableRequest request) throws AppValidationException {

    }

    @StringStringDGBothNotEmpty
    @Override
    public void validate(UserRegisterRequest request) throws AppValidationException {
        if (!EmailValidator.getInstance().isValid(request.getData1())) {
            throw new AppValidationException("Not valid EMail : " + request);
        }
        if (userService.exist(request.getData1())) {
            throw new AppValidationException("User already exists : " + request);
        }
    }

    @StringDGNotEmpty
    @Override
    public void validate(UserSetActiveRequest request) throws AppValidationException {
        if (!userService.exist(request.getData1())) {
            throw new AppValidationException("User don't exists : " + request);
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

    @IntIntDGBothNotEmpty
    @Override
    public void validate(ExpenseListPageableRequest request, User user) throws AppValidationException, AppDataIntegrityException {
        //check category - is it belongs to the user?
        if (!blService.isCategoryBelongToTheUser(categoryService.findById(request.getData3()), user)) {
            throw new AppDataIntegrityException("The category is not belongs to the user : " + request);
        }
    }

    @StringStringDGBothNotEmpty
    @Override
    public void validate(CurrensyRateCreateRequest request) throws AppValidationException {
        //TODO implement
        //check data1 & data2 for currency code pattern

        //check rate for rate pattern
        if (request.getData3() < 0) {
            throw new AppValidationException("Expense amount must be > 0 : " + request);
        }
    }

    @StringStringDGBothNotEmpty
    @Override
    public void validate(CurrencyRateCurrentRequest request) throws AppValidationException {
        //TODO implement
        //check data1 & data2 for currency code pattern

    }
}
