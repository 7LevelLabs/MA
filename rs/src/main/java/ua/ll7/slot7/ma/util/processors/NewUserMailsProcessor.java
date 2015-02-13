package ua.ll7.slot7.ma.util.processors;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.util.pubsub.events.UserSuccessfullyRegisterEvent;
import ua.ll7.slot7.ma.util.pubsub.listeners.IMAEventListener;

/**
 * MA
 * Velichko A.
 * 31.01.15 16:27
 */
@Component
public class NewUserMailsProcessor implements INewUserMailsProcessor, IMAEventListener<UserSuccessfullyRegisterEvent> {

  private static final Logger LOGGER = Logger.getLogger(NewUserMailsProcessor.class);

  @Override
  public void processMailsTasksForNewUser(User user) {
    LOGGER.debug(user.toString());
  }

  @Override
  public void onEvent(UserSuccessfullyRegisterEvent event) {
    processMailsTasksForNewUser(event.getUser());
  }
}
