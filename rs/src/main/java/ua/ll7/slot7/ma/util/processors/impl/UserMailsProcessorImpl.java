package ua.ll7.slot7.ma.util.processors.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.util.processors.IUserMailsProcessor;
import ua.ll7.slot7.ma.util.pubsub.events.UserSuccessfullyRegisterEvent;
import ua.ll7.slot7.ma.util.pubsub.events.UserUnsuccessfullyRegisterEvent;
import ua.ll7.slot7.ma.util.pubsub.listeners.IUserSuccessfullyRegisterEventListener;
import ua.ll7.slot7.ma.util.pubsub.listeners.IUserUnsuccessfullyRegisterEventListener;

/**
 * MA
 * Velichko A.
 * 03.03.15 9:31
 */
@Component
public class UserMailsProcessorImpl implements IUserMailsProcessor,
       IUserSuccessfullyRegisterEventListener,
       IUserUnsuccessfullyRegisterEventListener {

  private static final Logger LOGGER = Logger.getLogger(UserMailsProcessorImpl.class);

  @Override
  public void userSuccessfullyRegisterEMailProcess(User user) {
    LOGGER.debug("Send email to new Successfully registered user : " + user.toString());
  }

  @Override
  public void userUnSuccessfullyRegisterEMailProcess(User user) {
    LOGGER.debug("Send email to new Successfully registered user : " + user.toString());
  }

  @Override
  public void onEvent(UserSuccessfullyRegisterEvent event) {
    userSuccessfullyRegisterEMailProcess(event.getUser());
  }

  @Override
  public void onEvent(UserUnsuccessfullyRegisterEvent event) {
    userSuccessfullyRegisterEMailProcess(event.getUser());
  }


}
