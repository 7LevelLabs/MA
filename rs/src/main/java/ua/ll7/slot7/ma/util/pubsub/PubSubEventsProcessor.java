package ua.ll7.slot7.ma.util.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.util.processors.NewUserMailsProcessor;
import ua.ll7.slot7.ma.util.pubsub.events.MAEventRoot;
import ua.ll7.slot7.ma.util.pubsub.listeners.IMAEventListner;

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
  private NewUserMailsProcessor newUserMailsProcessor;

  private Map<Class, List<IMAEventListner>> eventListenersMap;

//
//  //eventsList
//  List<IMAEventListner> userSuccessfullyRegisterEventListeners = new LinkedList<>();
//
//  //listeners list
//  {
//    userSuccessfullyRegisterEventListeners.add(newUserMailsProcessor);
//
//    eventListenersMap.put(UserSuccessfullyRegisterEvent.class, userSuccessfullyRegisterEventListeners);
//  }

  public void fireUpEvent(MAEventRoot event) {
    List<IMAEventListner> listenersList = eventListenersMap.get(event.getClass());

    for (IMAEventListner aListener : listenersList) {
      aListener.onEvent(event);
    }
  }

  public Map<Class, List<IMAEventListner>> getEventListenersMap() {
    return eventListenersMap;
  }

  @Autowired
  public void setEventListenersMap(Map<Class, List<IMAEventListner>> eventListenersMap) {
    this.eventListenersMap = eventListenersMap;
  }
}
