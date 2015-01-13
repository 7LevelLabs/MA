package ua.ll7.slot7.ma.actor.di;

import akka.actor.Props;
import akka.actor.UntypedActorFactory;
import org.springframework.context.ApplicationContext;

/**
 * MA
 * Velichko A.
 * 13.01.15 17:35
 */
public class DependencyInjectionProps extends Props {

  public DependencyInjectionProps(ApplicationContext applicationContext, Class<?> actorClass) {
    super((UntypedActorFactory) new SpringUntypedActorFactory(actorClass, applicationContext));
  }

  public DependencyInjectionProps(ApplicationContext applicationContext, UntypedActorFactory factory) {
    super((UntypedActorFactory) new SpringUntypedActorFactory(factory, applicationContext));
  }

}
