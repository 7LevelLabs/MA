package ua.ll7.slot7.ma.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.magic.service.IUserMagicService;
import ua.ll7.slot7.ma.magic.service.impl.UserMagicServiceImpl;
import ua.ll7.slot7.ma.model.User;

import javax.annotation.PostConstruct;

/**
 * MA
 * Velichko A.
 * 27.12.14 10:41
 */
@Component
public class StarterImpl implements IStarter {

  private static final Logger LOGGER = Logger.getLogger(StarterImpl.class);

  @Value("${default.user.email}")
  private String defaultUserEMail;

  @Value("${default.user.password}")
  private String defaultUserPassword;

  private IUserMagicService userMagicService;

  @PostConstruct
  @Override
  public void onStart() {
    userMagicService = new UserMagicServiceImpl();

    createDefAccounts();
    notifyEMail();
    notifyLogging();
  }

  private void createDefAccounts() {
    if (userMagicService.count() == 0) {
      LOGGER.info("No Users - let's create one.");

      //TODO encode

      User user = MAFactory.getNewUser(defaultUserEMail, defaultUserEMail, defaultUserEMail, defaultUserPassword);
      userMagicService.create(user);
    }
  }

  private void notifyEMail() {

  }

  private void notifyLogging() {

  }
}
