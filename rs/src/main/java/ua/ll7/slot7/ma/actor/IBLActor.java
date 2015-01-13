package ua.ll7.slot7.ma.actor;

import ua.ll7.slot7.ma.data.request.UserRegisterRequest;

/**
 * @author velichko
 *         on 12.01.15 : 15:09
 */
public interface IBLActor {

  //User
  public void userCreate(UserRegisterRequest request) throws Exception;
}
