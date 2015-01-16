package ua.ll7.slot7.ma.configuration;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Inbox;
import akka.actor.Props;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import ua.ll7.slot7.ma.actor.di.SpringUntypedActorFactory;
import ua.ll7.slot7.ma.actor.impl.BLActorImpl;

/**
 * MA
 * Velichko A.
 * 13.01.15 17:59
 */
@Configuration
public class ActorsBootstrap {

  public static final String ACTOR_SYSTEM = "ma-actorSystem";
  public static final String MA_INBOX = "ma-inbox";
  public static final String BL_ACTOR     = "bl-actor";

  private ActorSystem actorSystem;

  private Inbox inbox;

  @Autowired
  private ApplicationContext applicationContext;

  @Bean(name = ACTOR_SYSTEM, destroyMethod = "shutdown")
  public ActorSystem actorSystem() {
    actorSystem = ActorSystem.create(ACTOR_SYSTEM);
    return actorSystem;
  }

  //ma-inbox
  @Bean(name = MA_INBOX)
  @DependsOn({ACTOR_SYSTEM})
  public Inbox inbox() {
    inbox = Inbox.create(actorSystem);
    return inbox;
  }

  //  bl-actor
  @Bean(name = BL_ACTOR)
  @DependsOn({ACTOR_SYSTEM})
  public ActorRef businessActor() {
    return actorSystem
           .actorOf(Props.create(new SpringUntypedActorFactory(BLActorImpl.class, applicationContext)),
                    BL_ACTOR);
  }
}
