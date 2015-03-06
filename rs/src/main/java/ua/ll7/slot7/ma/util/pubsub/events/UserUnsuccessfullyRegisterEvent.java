package ua.ll7.slot7.ma.util.pubsub.events;

import ua.ll7.slot7.ma.model.User;

/**
 * MA
 * Velichko A.
 * 03.03.15 9:41
 */
public class UserUnsuccessfullyRegisterEvent extends MAEventRoot {

  private final User user;

  public UserUnsuccessfullyRegisterEvent(Object source, User user) {
    super(source);
    this.user = user;
  }

  public User getUser() {
    return user;
  }
}
