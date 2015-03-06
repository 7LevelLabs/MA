package ua.ll7.slot7.ma.util.creators;

import org.junit.Test;
import ua.ll7.slot7.ma.data.Constants;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.model.UserARToken;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserARTokenBuilderTest {

  @Test
  public void testBuild() throws Exception {
    User user = new UserBuilder("email", "password").build();

    UserARToken userARToken = new UserARTokenBuilder(user).build();

    System.out.println(userARToken);

    assertEquals(userARToken.getEmail(), "email");
    assertEquals(userARToken.getTokenCode().length(), Constants.userARTLength);

    assertTrue(Math.abs((userARToken.getPeriodEnd().getTime() - userARToken.getPeriodBegin().getTime()) - Constants.userARTPeriodLength) < 2L);
  }
}