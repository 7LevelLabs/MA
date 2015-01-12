package ua.ll7.slot7.ma.controller.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.ll7.slot7.ma.actor.IBLActor;
import ua.ll7.slot7.ma.controller.IRegisteredUserController;
import ua.ll7.slot7.ma.data.Constants;
import ua.ll7.slot7.ma.data.generic.MAGenericResponse;
import ua.ll7.slot7.ma.data.request.*;
import ua.ll7.slot7.ma.data.response.MACategoryForTheUserVOListResponse;
import ua.ll7.slot7.ma.data.response.MACurrencyRateCurrentResponse;
import ua.ll7.slot7.ma.data.response.MAExpenseVOListResponse;
import ua.ll7.slot7.ma.exception.AppDataIntegrityException;
import ua.ll7.slot7.ma.exception.AppValidationException;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.IUserService;
import ua.ll7.slot7.ma.util.MAFactory;
import ua.ll7.slot7.ma.util.MAStatusCode;
import ua.ll7.slot7.ma.validator.IRequestValidator;

/**
 * @author Alex Velichko
 *         30.12.14 : 0:03
 */
@Controller
@RequestMapping(Constants.controllerEndpointRUController)
public class RegisteredUserControllerImpl implements IRegisteredUserController {

	private static final Logger LOGGER = Logger.getLogger(RegisteredUserControllerImpl.class);

	@Autowired
	private IRequestValidator requestValidator;

	@Autowired
	private IUserService userService;

	@Autowired
	private IBLActor blActor;

	@Override
	@RequestMapping(value = Constants.methodEndpointCategoryCreate,
				 method = RequestMethod.PUT,
				 consumes = MediaType.APPLICATION_JSON_VALUE,
				 produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MAGenericResponse> categoryCreate(
				 @RequestBody
				 CategoryCreateRequest request
	) {

		MAGenericResponse response = new MAGenericResponse();

		User user = getCurrentlyPrincipal();

		try {
			requestValidator.validate(request, user);
		} catch (AppValidationException e) {
			LOGGER.debug(e.getMessage());
			response.setStatusCode(MAStatusCode.NOT_VALID_REQUEST);
			response.setMessage(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		blActor.categoryCreateForUser(user, request.getData1(), "");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = Constants.methodEndpointCategoryUpdate,
				 method = RequestMethod.PUT,
				 consumes = MediaType.APPLICATION_JSON_VALUE,
				 produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MAGenericResponse> categoryUpdate(
				 @RequestBody
				 CategoryUpdateRequest request
	) {
		MAGenericResponse response = new MAGenericResponse();

		try {
			requestValidator.validate(request);
		} catch (AppValidationException e) {
			LOGGER.debug(e.getMessage());
			response.setStatusCode(MAStatusCode.NOT_VALID_REQUEST);
			response.setMessage(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		blActor.categoryUpdate(request);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = Constants.methodEndpointCategoryList,
											 method = RequestMethod.GET,
											 consumes = MediaType.APPLICATION_JSON_VALUE,
											 produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MACategoryForTheUserVOListResponse> categoryList() {

		MACategoryForTheUserVOListResponse response = new MACategoryForTheUserVOListResponse();
		User user = getCurrentlyPrincipal();

		response.setData1(MAFactory.getCategoryForTheUserVOList(blActor.categoryListForTheUser(user)));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = Constants.methodEndpointExpenseCreate,
											 method = RequestMethod.PUT,
											 consumes = MediaType.APPLICATION_JSON_VALUE,
											 produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MAGenericResponse> expenseCreate(
											 @RequestBody
											 ExpenseCreateRequest request
	) {

		MAGenericResponse response = new MAGenericResponse();
		User user = getCurrentlyPrincipal();

		try {
			requestValidator.validate(request, user);
		} catch (AppValidationException e) {
			LOGGER.debug(e.getMessage());
			response.setStatusCode(MAStatusCode.NOT_VALID_REQUEST);
			response.setMessage(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		} catch (AppDataIntegrityException e) {
			LOGGER.debug(e.getMessage());
			response.setStatusCode(MAStatusCode.NOT_VALID_REQUEST);
			response.setMessage(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		blActor.expenseCreateForCategoryUSD(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = Constants.methodEndpointExpenseList,
											 method = RequestMethod.PUT,
											 consumes = MediaType.APPLICATION_JSON_VALUE,
											 produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MAExpenseVOListResponse> expenseList(
											 @RequestBody
											 ExpenseListPageableRequest request
	) {

		MAExpenseVOListResponse response = new MAExpenseVOListResponse();
		User user = getCurrentlyPrincipal();

		try {
			requestValidator.validate(request, user);
		} catch (AppValidationException e) {
			LOGGER.debug(e.getMessage());
			response.setStatusCode(MAStatusCode.NOT_VALID_REQUEST);
			response.setMessage(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		} catch (AppDataIntegrityException e) {
			LOGGER.debug(e.getMessage());
			response.setStatusCode(MAStatusCode.NOT_VALID_REQUEST);
			response.setMessage(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		response.setData1(blActor.expenseList(request));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = Constants.methodEndpointCurrencyRateGetCurrent,
				 method = RequestMethod.GET,
				 consumes = MediaType.APPLICATION_JSON_VALUE,
				 produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MACurrencyRateCurrentResponse> currencyRateCurrent(
				 @RequestBody
				 CurrencyRateCurrentRequest request
	) {

		MACurrencyRateCurrentResponse response = new MACurrencyRateCurrentResponse();

		try {
			requestValidator.validate(request);
		} catch (AppValidationException e) {
			LOGGER.debug(e.getMessage());
			response.setStatusCode(MAStatusCode.NOT_VALID_REQUEST);
			response.setMessage(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		response.setData1(blActor.currensyRateCurrent(request));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private User getCurrentlyPrincipal() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String authName = auth.getName();
		return userService.findByEMail(authName);
	}
}
