package ua.ll7.slot7.ma.util.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.util.processors.NewUserMailsProcessor;
import ua.ll7.slot7.ma.util.pubsub.events.MAEventRoot;
import ua.ll7.slot7.ma.util.pubsub.listeners.IMAEventListener;

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

  private Map<Class, List<IMAEventListener>> eventListenersMap;

  public void fireUpEvent(MAEventRoot event) {
    List<IMAEventListener> listenersList = eventListenersMap.get(event.getClass());

    for (IMAEventListener aListener : listenersList) {
      aListener.onEvent(event);
    }
  }

  public Map<Class, List<IMAEventListener>> getEventListenersMap() {
    return eventListenersMap;
  }

  @Autowired
  public void setEventListenersMap(Map<Class, List<IMAEventListener>> eventListenersMap) {
    this.eventListenersMap = eventListenersMap;
  }
}
