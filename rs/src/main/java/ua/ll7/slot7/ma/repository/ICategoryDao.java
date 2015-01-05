package ua.ll7.slot7.ma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.User;

import java.util.List;

/**
 * @author Alex Velichko
 *         09.06.14 : 17:36
 */

/**
 * CategoryForTheUser-specific DAO-staff
 */
public interface ICategoryDao extends JpaRepository<CategoryForTheUser, Long> {

	@Query("select cfu from CategoryForTheUser cfu where cfu.user = ?1 and cfu.name = ?2")
	public CategoryForTheUser findByUserAndName(User user, String name);

	@Query("select cfu from CategoryForTheUser cfu where cfu.user = ?1")
	public List<CategoryForTheUser> findByUser(User user);

	@Query("select cfu.name from CategoryForTheUser cfu group by cfu.name having count (cfu.name) > ?1 order by count (cfu.name) desc")
	public List<String> getPopularCategoryNames(long i);

}
