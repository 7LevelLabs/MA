package ua.ll7.slot7.ma.controller.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.ll7.slot7.ma.actor.IBLActor;
import ua.ll7.slot7.ma.controller.IAnonymousController;
import ua.ll7.slot7.ma.data.Constants;
import ua.ll7.slot7.ma.data.generic.MAGenericResponse;
import ua.ll7.slot7.ma.data.request.UserRegisterRequest;
import ua.ll7.slot7.ma.exception.AppValidationException;
import ua.ll7.slot7.ma.util.LogAround;
import ua.ll7.slot7.ma.util.MAStatusCode;
import ua.ll7.slot7.ma.validator.IRequestValidator;

/**
 * MA
 * Velichko A.
 * 26.12.14 18:07
 */
@Controller
@RequestMapping(Constants.controllerEndpointAnonController)
public class AnonymousControllerImpl implements IAnonymousController {

	private static final Logger LOGGER = Logger.getLogger(AnonymousControllerImpl.class);

	@Autowired
	private IRequestValidator requestValidator;

	@Autowired
	private IBLActor blActor;

	@LogAround
	@Override
	@RequestMapping(value = Constants.methodEndpointUserCreate,
				 method = RequestMethod.PUT,
				 consumes = MediaType.APPLICATION_JSON_VALUE,
				 produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MAGenericResponse> registerNewUser(
				 @RequestBody
				 UserRegisterRequest request
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

		blActor.userCreate(request);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
