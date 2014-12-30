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
import ua.ll7.slot7.ma.controller.IRegisteredUserController;
import ua.ll7.slot7.ma.data.Constants;
import ua.ll7.slot7.ma.data.generic.MAGenericResponse;
import ua.ll7.slot7.ma.data.request.CategoryCreateRequest;
import ua.ll7.slot7.ma.data.response.MACategoryForTheUserVOListResponse;
import ua.ll7.slot7.ma.exception.AppValidationException;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.IBLService;
import ua.ll7.slot7.ma.service.IUserService;
import ua.ll7.slot7.ma.util.MAFactory;
import ua.ll7.slot7.ma.util.MAStatusCode;
import ua.ll7.slot7.ma.validator.IRequestValidator;

import java.util.List;

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
	private IBLService blService;

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

		blService.categoryCreateForUser(user, request.getData1(), "");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = Constants.methodEndpointCategoryList,
											 method = RequestMethod.PUT,
											 consumes = MediaType.APPLICATION_JSON_VALUE,
											 produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MACategoryForTheUserVOListResponse> categoryList() {

		MACategoryForTheUserVOListResponse response = new MACategoryForTheUserVOListResponse();
		User user = getCurrentlyPrincipal();

		response.setData1(MAFactory.getCategoryForTheUserVOList(blService.categoryListForTheUser(user)));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private User getCurrentlyPrincipal() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String authName = auth.getName();
		return userService.findByEMail(authName);
	}
}
