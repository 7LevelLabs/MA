package ua.ll7.slot7.ma.util.email;

import java.util.Date;

/**
 * MA
 * Velichko A.
 * 22.01.15 12:57
 */
public interface IMailBodyProcessor {

  public String userRegisteringProcessToken(final String nick,
                                            final String email,
                                            final String token,
                                            final Date periodBegin,
                                            final Date periodEnd);

  public String userWelcomeAboard(final String nick,
                                  final String email);

}
