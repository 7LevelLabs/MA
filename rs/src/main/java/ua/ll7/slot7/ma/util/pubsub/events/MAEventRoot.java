package ua.ll7.slot7.ma.util.pubsub.events;

import java.util.EventObject;

/**
 * MA
 * Velichko A.
 * 31.01.15 15:23
 */
public class MAEventRoot extends EventObject {

  /**
   * Constructs a prototypical Event.
   *
   * @param source The object on which the Event initially occurred.
   * @throws IllegalArgumentException if source is null.
   */
  public MAEventRoot(Object source) {
    super(source);
  }
}
