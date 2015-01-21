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
import ua.ll7.slot7.ma.controller.IAdminController;
import ua.ll7.slot7.ma.data.Constants;
import ua.ll7.slot7.ma.data.generic.MAGenericResponse;
import ua.ll7.slot7.ma.data.request.CurrensyRateCreateRequest;
import ua.ll7.slot7.ma.data.request.UserListPageableRequest;
import ua.ll7.slot7.ma.data.request.UserSetActiveRequest;
import ua.ll7.slot7.ma.data.response.MAUserVOListResponse;
import ua.ll7.slot7.ma.exception.AppValidationException;
import ua.ll7.slot7.ma.service.IBLService;
import ua.ll7.slot7.ma.util.MAStatusCode;
import ua.ll7.slot7.ma.validator.IRequestValidator;

/**
 * @author Alex Velichko
 *         05.01.15 : 14:01
 */
@Controller
@RequestMapping(Constants.controllerEndpointAdmController)
public class AdminControllerImpl implements IAdminController {

  private static final Logger LOGGER = Logger.getLogger(AdminControllerImpl.class);

  @Autowired
  private IRequestValidator requestValidator;

  @Autowired
  private IBLService iblService;

  @Override
  @RequestMapping(value = Constants.methodEndpointUserList,
         method = RequestMethod.GET,
         consumes = MediaType.APPLICATION_JSON_VALUE,
         produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<MAUserVOListResponse> userList() {
    MAUserVOListResponse response = new MAUserVOListResponse();
    response.setData1(iblService.userList());

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Override
  @RequestMapping(value = Constants.methodEndpointUserListPageable,
         method = RequestMethod.GET,
         consumes = MediaType.APPLICATION_JSON_VALUE,
         produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<MAUserVOListResponse> userListPageable(
         @RequestBody
         UserListPageableRequest request
  ) {

    MAUserVOListResponse response = new MAUserVOListResponse();

    try {
      requestValidator.validate(request);
    } catch (AppValidationException e) {
      LOGGER.debug(e.getMessage());
      response.setStatusCode(MAStatusCode.NOT_VALID_REQUEST);
      response.setMessage(e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    response.setData1(iblService.userListPageable(request));

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Override
  @RequestMapping(value = Constants.methodEndpointUserSetActive,
         method = RequestMethod.PUT,
         consumes = MediaType.APPLICATION_JSON_VALUE,
         produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<MAGenericResponse> userSetActive(
         @RequestBody
         UserSetActiveRequest request
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

    iblService.userSetActive(request);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Override
  @RequestMapping(value = Constants.methodEndpointCurrencyRateCreate,
         method = RequestMethod.PUT,
         consumes = MediaType.APPLICATION_JSON_VALUE,
         produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<MAGenericResponse> currencyRateCreate(
         @RequestBody
         CurrensyRateCreateRequest request
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

    iblService.currensyRateCreate(request);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
