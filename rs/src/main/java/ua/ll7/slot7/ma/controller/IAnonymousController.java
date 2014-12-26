package ua.ll7.slot7.ma.controller;

import org.springframework.http.ResponseEntity;
import ua.ll7.slot7.ma.data.request.UserRegisterRequest;
import ua.ll7.slot7.ma.data.response.MALongResponse;

/**
 * MA
 * Velichko A.
 * 26.12.14 17:08
 */
public interface IAnonymousController {
  public ResponseEntity<MALongResponse> registerNewUser(UserRegisterRequest request);

}
