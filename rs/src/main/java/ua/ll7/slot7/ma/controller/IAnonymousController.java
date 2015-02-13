package ua.ll7.slot7.ma.controller;

import org.springframework.http.ResponseEntity;
import ua.ll7.slot7.ma.data.generic.MAGenericResponse;
import ua.ll7.slot7.ma.data.request.UserRegisterConfirmation;
import ua.ll7.slot7.ma.data.request.UserRegisterRequest;

/**
 * MA
 * Velichko A.
 * 26.12.14 17:08
 */
public interface IAnonymousController {

  public ResponseEntity<MAGenericResponse> registerNewUser(UserRegisterRequest request);

  public ResponseEntity<MAGenericResponse> registerConfirmation(UserRegisterConfirmation request);
}
