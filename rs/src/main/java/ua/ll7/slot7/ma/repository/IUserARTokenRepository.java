package ua.ll7.slot7.ma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ll7.slot7.ma.model.UserARToken;

/**
 * MA
 * Velichko A.
 * 13.02.15 18:58
 */
public interface IUserARTokenRepository extends JpaRepository<UserARToken, Long> {

  public UserARToken findByEmail(String email);
}
