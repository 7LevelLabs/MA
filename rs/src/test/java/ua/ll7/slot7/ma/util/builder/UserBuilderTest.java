package ua.ll7.slot7.ma.util.builder;

import org.junit.Test;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.util.builder.UserBuilder;

import static org.junit.Assert.assertTrue;

public class UserBuilderTest {
  
  @Test
  public void testBuild() throws Exception {
    User user = new UserBuilder("email","password")
      .build();
    
    assertTrue(!user.getPassword().equals("password"));
    
  }
}
