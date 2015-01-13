package ua.ll7.slot7.ma.configuration;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import ua.ll7.slot7.ma.actor.di.DependencyInjectionProps;
import ua.ll7.slot7.ma.actor.impl.BLActorImpl;

/**
 * MA
 * Velichko A.
 * 13.01.15 17:59
 */
@Configuration
public class ActorsBootstrap {

  public static final String ACTOR_SYSTEM = "ma-actorSystem";
  public static final String BL_ACTOR     = "bl-actor";

  private ActorSystem actorSystem;

  @Autowired
  private ApplicationContext applicationContext;

  @Bean(name = ACTOR_SYSTEM, destroyMethod = "shutdown")
  public ActorSystem actorSystem() {
    actorSystem = ActorSystem.create(ACTOR_SYSTEM);
    return actorSystem;
  }

  @Bean(name = BL_ACTOR)
  @DependsOn({ACTOR_SYSTEM})
  public ActorRef businessActor() {
    return actorSystem
           .actorOf(new DependencyInjectionProps(
                  applicationContext,
                  BLActorImpl.class), BL_ACTOR);
  }

}
