package ua.ll7.slot7.ma.util.pubsub.listeners;

import ua.ll7.slot7.ma.util.pubsub.events.UserSuccessfullyRegisterEvent;

/**
 * MA
 * Velichko A.
 * 06.03.15 13:54
 */
public interface IUserSuccessfullyRegisterEventListener extends IMAEventListener {

  public void onEvent(UserSuccessfullyRegisterEvent event);
}
