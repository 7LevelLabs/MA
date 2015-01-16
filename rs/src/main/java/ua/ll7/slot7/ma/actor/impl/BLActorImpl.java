package ua.ll7.slot7.ma.actor.impl;

import akka.actor.Inbox;
import akka.actor.UntypedActor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ua.ll7.slot7.ma.actor.IBLActor;
import ua.ll7.slot7.ma.configuration.ActorsBootstrap;
import ua.ll7.slot7.ma.data.request.UserRegisterRequest;
import ua.ll7.slot7.ma.service.IBLService;

/**
 * @author velichko
 *         on 12.01.15 : 15:13
 */
public class BLActorImpl extends UntypedActor implements IBLActor {

  @Autowired
  private IBLService blService;

  @Autowired
  @Qualifier(ActorsBootstrap.MA_INBOX)
  private Inbox inbox;

  private Integer state = 0;

  @Override
  public void onReceive(Object o) throws Exception {
    if (o instanceof UserRegisterRequest) {
      try {
        blService.userCreate((UserRegisterRequest) o);
      } catch (Exception e) {
        state = 1;
      } finally {
        inbox.send(getSelf(), state);
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
