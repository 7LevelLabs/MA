package ua.ll7.slot7.ma.actor.di;

import akka.actor.Props;
import akka.actor.UntypedActorFactory;
import org.springframework.context.ApplicationContext;

public class DependencyInjectionProps extends Props {

  /**
   * No-args constructor that sets all the default values.
   */
  public DependencyInjectionProps(ApplicationContext applicationContext, Class<?> actorClass) {
    super(new SpringUntypedActorFactory(actorClass, applicationContext));
  }

  /**
   * Java API.
   */
  public DependencyInjectionProps(ApplicationContext applicationContext, UntypedActorFactory factory) {
    super(new SpringUntypedActorFactory(factory, applicationContext));
  }

}
