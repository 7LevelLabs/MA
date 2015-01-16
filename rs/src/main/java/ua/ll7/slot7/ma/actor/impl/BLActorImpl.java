package ua.ll7.slot7.ma.actor.impl;

import akka.actor.UntypedActor;
import org.springframework.beans.factory.annotation.Autowired;
import ua.ll7.slot7.ma.actor.IBLActor;
import ua.ll7.slot7.ma.data.request.UserRegisterRequest;
import ua.ll7.slot7.ma.service.IBLService;

/**
 * @author velichko
 *         on 12.01.15 : 15:13
 */
public class BLActorImpl extends UntypedActor implements IBLActor {

  @Autowired
  private IBLService blService;

  private Integer state = 0;

  @Override
  public void onReceive(Object o) throws Exception {
    if (o instanceof UserRegisterRequest) {

      try {
        blService.userCreate((UserRegisterRequest) o);
      } catch (Exception e) {
        state = 1;
      }
    } else {
      unhandled(o);
    }
  }

  @Override
  public void userCreate(UserRegisterRequest request) throws Exception {
    onReceive(request);
  }

  public Integer getState() {
    return state;
  }
}
