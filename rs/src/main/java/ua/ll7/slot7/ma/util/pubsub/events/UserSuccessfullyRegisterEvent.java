package ua.ll7.slot7.ma.util.pubsub.events;

import ua.ll7.slot7.ma.model.User;

/**
 * MA
 * Velichko A.
 * 31.01.15 15:33
 */
public class UserSuccessfullyRegisterEvent extends MAEventRoot {

  private final User user;

  public UserSuccessfullyRegisterEvent(Object source, User user) {
    super(source);
    this.user = user;
  }

  public User getUser() {
    return user;
  }
}
