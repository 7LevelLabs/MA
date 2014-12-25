package ua.ll7.slot7.ma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ll7.slot7.ma.model.User;

/**
 * @author Alex Velichko
 *         09.06.14 : 17:35
 */

/**
 * User-specific DAO-staff
 */
public interface IUserRepository extends JpaRepository<User, Long> {
	public User findByEmail(String email);
}
