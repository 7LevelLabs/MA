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
import ua.ll7.slot7.ma.controller.IAnonymousController;
import ua.ll7.slot7.ma.data.Constants;
import ua.ll7.slot7.ma.data.request.UserRegisterRequest;
import ua.ll7.slot7.ma.data.response.MALongResponse;
import ua.ll7.slot7.ma.exception.AppValidationException;
import ua.ll7.slot7.ma.service.IBLService;
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
	private IBLService blService;

	@Override
	@RequestMapping(value = Constants.methodEndpointUserCreate,
											 method = RequestMethod.PUT,
											 consumes = MediaType.APPLICATION_JSON_VALUE,
											 produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MALongResponse> registerNewUser(
											 @RequestBody
											 UserRegisterRequest request
	) {
		MALongResponse response = new MALongResponse();

		try {
			requestValidator.validate(request);
		} catch (AppValidationException e) {
			LOGGER.debug(e.getMessage());
			response.setStatusCode(MAStatusCode.NOT_VALID_REQUEST);
			response.setMessage(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		response.setData1(blService.userCreate(request.getData1(), request.getData2()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
