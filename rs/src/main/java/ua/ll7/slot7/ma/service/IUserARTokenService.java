package ua.ll7.slot7.ma.service;

import ua.ll7.slot7.ma.model.UserARToken;

/**
 * MA
 * Velichko A.
 * 13.02.15 19:02
 */
public interface IUserARTokenService {

  public void save(UserARToken userARToken);

  public String findByEmail(String email);
}
