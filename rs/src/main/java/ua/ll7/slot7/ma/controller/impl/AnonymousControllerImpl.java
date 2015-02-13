package ua.ll7.slot7.ma.controller.impl;

import akka.actor.ActorRef;
import akka.actor.Inbox;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import scala.concurrent.duration.Duration;
import ua.ll7.slot7.ma.configuration.ActorsBootstrap;
import ua.ll7.slot7.ma.controller.IAnonymousController;
import ua.ll7.slot7.ma.data.Constants;
import ua.ll7.slot7.ma.data.generic.MAGenericResponse;
import ua.ll7.slot7.ma.data.request.UserRegisterConfirmation;
import ua.ll7.slot7.ma.data.request.UserRegisterRequest;
import ua.ll7.slot7.ma.exception.AppValidationException;
import ua.ll7.slot7.ma.util.MAStatusCode;
import ua.ll7.slot7.ma.validator.IRequestValidator;

import java.util.concurrent.TimeUnit;

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
  @Qualifier(ActorsBootstrap.BL_ACTOR)
  private ActorRef blActor;

  @Autowired
  @Qualifier(ActorsBootstrap.MA_INBOX)
  private Inbox inbox;

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

    inbox.send(blActor, request);

    try {
      if (inbox.receive(Duration.create(1, TimeUnit.SECONDS)).equals(1)) {
        response.setStatusCode(MAStatusCode.EXCEPTION);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    } catch (Exception e) {
      response.setStatusCode(MAStatusCode.EXCEPTION);
      response.setMessage(e.getMessage());
      LOGGER.debug(e);
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<MAGenericResponse> registerConfirmation(UserRegisterConfirmation request) {
    //TODO implement
    return null;
  }
}
