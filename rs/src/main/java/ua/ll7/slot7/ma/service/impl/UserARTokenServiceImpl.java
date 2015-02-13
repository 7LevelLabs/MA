package ua.ll7.slot7.ma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.model.UserARToken;
import ua.ll7.slot7.ma.repository.IUserARTokenRepository;
import ua.ll7.slot7.ma.service.IUserARTokenService;

/**
 * MA
 * Velichko A.
 * 13.02.15 19:04
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class UserARTokenServiceImpl implements IUserARTokenService {

  @Autowired
  private IUserARTokenRepository repository;

  @Override
  public void save(UserARToken userARToken) {
    UserARToken userARTokenExists = repository.findByEmail(userARToken.getEmail());
    if (userARTokenExists != null) {
      repository.delete(userARTokenExists);
    }
    repository.save(userARToken);
  }

  @Override
  public String findByEmail(String email) {
    UserARToken userARToken = repository.findByEmail(email);
    if (userARToken != null) {
      return userARToken.getTokenCode();
    }
    return null;
  }
}
