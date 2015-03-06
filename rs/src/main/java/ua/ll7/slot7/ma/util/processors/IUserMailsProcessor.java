package ua.ll7.slot7.ma.util.processors;

import ua.ll7.slot7.ma.model.User;

/**
 * MA
 * Velichko A.
 * 03.03.15 9:25
 */
public interface IUserMailsProcessor {

  public void userSuccessfullyRegisterEMailProcess(User user);

  public void userUnSuccessfullyRegisterEMailProcess(User user);
}
