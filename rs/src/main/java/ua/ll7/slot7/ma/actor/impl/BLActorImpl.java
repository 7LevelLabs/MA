package ua.ll7.slot7.ma.actor.impl;

import akka.actor.UntypedActor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ua.ll7.slot7.ma.actor.IBLActor;
import ua.ll7.slot7.ma.data.request.UserListPageableRequest;
import ua.ll7.slot7.ma.data.request.UserRegisterRequest;
import ua.ll7.slot7.ma.service.IBLService;

/**
 * @author velichko
 *         on 12.01.15 : 15:13
 */
public class BLActorImpl extends UntypedActor implements IBLActor {

  private static final Logger LOGGER = Logger.getLogger(BLActorImpl.class);

  @Autowired
  private IBLService blService;

  @Override
  public void onReceive(Object o) throws Exception {
    blService.userListPageable((UserListPageableRequest) o);
  }

  @Override
  public void userCreate(UserRegisterRequest request) throws Exception {
    onReceive(request);
  }
}
