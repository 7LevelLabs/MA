package ua.ll7.slot7.ma.actor.impl;

import akka.actor.TypedActor;
import org.apache.log4j.Logger;
import ua.ll7.slot7.ma.actor.IServiceActor;

/**
 * @author velichko
 *         on 10.01.15 : 15:43
 */
public class ServiceActorImpl extends TypedActor implements IServiceActor {

  private static final Logger LOGGER = Logger.getLogger(ServiceActorImpl.class);

  @Override
  public void processData(String data) {
    LOGGER.info(data);
  }
}
