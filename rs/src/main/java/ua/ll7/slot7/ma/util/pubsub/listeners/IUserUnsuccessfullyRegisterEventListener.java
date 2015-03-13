package ua.ll7.slot7.ma.util.pubsub.listeners;

import ua.ll7.slot7.ma.util.pubsub.events.UserUnsuccessfullyRegisterEvent;

/**
 * MA
 * Velichko A.
 * 12.03.15 11:56
 */
public interface IUserUnsuccessfullyRegisterEventListener extends IMAEventListener {

  public void onEvent(UserUnsuccessfullyRegisterEvent event);
}
