package ua.ll7.slot7.ma.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * MA
 * Velichko A.
 * 27.12.14 10:41
 */
@Component
public class StarterImpl implements IStarter {

  @Value("${default.user.email}")
  private String defaultUserEMail;

  @Value("${default.user.password}")
  private String defaultUserPassword;

  @PostConstruct
  @Override
  public void onStart() {

  }
}
