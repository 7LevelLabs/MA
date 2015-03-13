package ua.ll7.slot7.ma.util.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.util.processors.impl.NewUserMailsTasksCreatorImpl;
import ua.ll7.slot7.ma.util.pubsub.events.UserSuccessfullyRegisterEvent;
import ua.ll7.slot7.ma.util.pubsub.events.UserUnsuccessfullyRegisterEvent;
import ua.ll7.slot7.ma.util.pubsub.listeners.IMAEventListener;
import ua.ll7.slot7.ma.util.pubsub.listeners.IUserSuccessfullyRegisterEventListener;
import ua.ll7.slot7.ma.util.pubsub.listeners.IUserUnsuccessfullyRegisterEventListener;

import java.util.List;
import java.util.Map;

/**
 * MA
 * Velichko A.
 * 31.01.15 15:42
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PubSubEventsProcessor {

  @Autowired
  private NewUserMailsTasksCreatorImpl newUserMailsProcessor;

  private Map<Class, List<? extends IMAEventListener>> eventListenersMap;

  public void fireUpEvent(UserSuccessfullyRegisterEvent event) {
    Class eventClass = event.getClass();
    List<IUserSuccessfullyRegisterEventListener> listenersList = (List<IUserSuccessfullyRegisterEventListener>) eventListenersMap.get(eventClass);

    for (IUserSuccessfullyRegisterEventListener aListener : listenersList) {
      aListener.onEvent(event);
    }
  }

  public void fireUpEvent(UserUnsuccessfullyRegisterEvent event) {
    Class eventClass = event.getClass();
    List<IUserUnsuccessfullyRegisterEventListener> listenersList = (List<IUserUnsuccessfullyRegisterEventListener>) eventListenersMap.get(eventClass);

    for (IUserUnsuccessfullyRegisterEventListener aListener : listenersList) {
      aListener.onEvent(event);
    }
  }

  public Map<Class, List<? extends IMAEventListener>> getEventListenersMap() {
    return eventListenersMap;
  }

  @Autowired
  public void setEventListenersMap(Map<Class, List<? extends IMAEventListener>> eventListenersMap) {
    this.eventListenersMap = eventListenersMap;
  }
}
