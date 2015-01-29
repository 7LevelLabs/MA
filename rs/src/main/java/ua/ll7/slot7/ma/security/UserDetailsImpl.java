package ua.ll7.slot7.ma.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.data.Constants;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.IUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * MA
 * Velichko A.
 * 20.01.15 17:25
 */
@Component
public class UserDetailsImpl implements UserDetailsService {

  private final Logger LOGGER = Logger.getLogger(UserDetailsImpl.class);

  @Autowired
  private IUserService userService;

  /**
   * Wraps {@link String} roles to {@link org.springframework.security.core.authority.SimpleGrantedAuthority} objects
   *
   * @param roles {@link String} of roles
   * @return list of granted authorities
   */
  public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
    List<GrantedAuthority> authorities = new ArrayList<>();
    for (String role : roles) {
      authorities.add(new SimpleGrantedAuthority(role));
    }
    return authorities;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserDetails userDetails;

    User user = userService.findByEMail(username);

    if (user == null) {
      throw new UsernameNotFoundException(username);
    }

    boolean enabled = true;
    boolean accountNonExpired = true;
    boolean credentialsNonExpired = true;
    boolean accountNonLocked = true;

    userDetails = new org.springframework.security.core.userdetails.User(
           user.getEmail(),
           user.getPassword(),
           enabled,
           accountNonExpired,
           credentialsNonExpired,
           accountNonLocked,
           getAuthorities(user.getRole()));

    return userDetails;
  }

  /**
   * Converts a numerical userrole to an equivalent list of roles
   *
   * @param role the numerical userrole
   * @return list of roles as as a list of {@link String}
   */
  public List<String> getRoles(int role) {
    List<String> roles = new ArrayList<>();
    switch (role) {
      case 1:
        roles.add(Constants.userRole_REGISTERED);
        break;
      case 10:
        roles.add(Constants.userRole_ADMIN);
        break;
    }
    return roles;
  }

  /**
   * Retrieves a collection of {@link org.springframework.security.core.GrantedAuthority} based on a numerical userrole
   *
   * @param role the numerical userrole
   * @return a collection of {@link org.springframework.security.core.GrantedAuthority}
   */
  public List<? extends GrantedAuthority> getAuthorities(int role) {
    return getGrantedAuthorities(getRoles(role));
  }


}
