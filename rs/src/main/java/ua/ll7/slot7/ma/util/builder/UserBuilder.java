package ua.ll7.slot7.ma.util.builder;

import org.springframework.security.crypto.password.StandardPasswordEncoder;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.User;

import java.util.LinkedList;
import java.util.UUID;

/**
 * MA
 * Velichko A.
 * 27.12.14 11:12
 */
public class UserBuilder {

  private User user;

  public UserBuilder(String email, String password) {
    user = new User();
    user.setEmail(email);

    StandardPasswordEncoder encoder = new StandardPasswordEncoder();
    String passwordEncoded = encoder.encode(password);

    user.setPassword(passwordEncoded);
    user.setRole(1);
    user.setActive(false);

    user.setApiCode(UUID.randomUUID().toString());
    user.setCategories(new LinkedList<CategoryForTheUser>());
  }

  public UserBuilder withName(String name) {
    user.setName(name);
    return this;
  }

  public UserBuilder withNick(String nick) {
    user.setNick(nick);
    return this;
  }

  public UserBuilder withRole(int role) {
    user.setRole(role);
    return this;
  }

  public UserBuilder withActive(boolean active) {
    user.setActive(active);
    return this;
  }

  public User build() {
    return user;
  }

}
