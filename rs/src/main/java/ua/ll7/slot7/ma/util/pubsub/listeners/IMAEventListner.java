package ua.ll7.slot7.ma.util.pubsub.listeners;

import ua.ll7.slot7.ma.util.pubsub.events.MAEventRoot;

/**
 * MA
 * Velichko A.
 * 31.01.15 15:29
 */
public interface IMAEventListner <T extends MAEventRoot> {

  public void onEvent(T event);
}
