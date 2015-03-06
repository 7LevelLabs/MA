package ua.ll7.slot7.ma.util.pubsub.listeners;

import ua.ll7.slot7.ma.util.pubsub.events.UserUnsuccessfullyRegisterEvent;

/**
 * MA
 * Velichko A.
 * 06.03.15 13:52
 */
public interface IUserUnsuccessfullyRegisterEventListener extends IMAEventListener {

  public void onEvent(UserUnsuccessfullyRegisterEvent event);
}
