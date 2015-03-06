package ua.ll7.slot7.ma.util.creators;

import ua.ll7.slot7.ma.data.Constants;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.model.UserARToken;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;

/**
 * MA
 * Velichko A.
 * 13.02.15 19:08
 */
public class UserARTokenBuilder {

  private UserARToken userARToken;

  public UserARTokenBuilder(User user) {
    userARToken = new UserARToken();
    userARToken.setEmail(user.getEmail());

    SecureRandom random = new SecureRandom();
    userARToken.setTokenCode(new BigInteger(130, random).toString(Constants.userARTLength).substring(0, Constants.userARTLength));
    userARToken.setPeriodBegin(new Date());
    userARToken.setPeriodEnd(new Date(System.currentTimeMillis() + Constants.userARTPeriodLength));
  }

  public UserARTokenBuilder withPeriodBeginPeriodEnd(Date periodBegin, Date periodEnd) {
    userARToken.setPeriodBegin(periodBegin);
    userARToken.setPeriodEnd(periodEnd);
    return this;
  }

  public UserARToken build() {
    return userARToken;
  }

}
