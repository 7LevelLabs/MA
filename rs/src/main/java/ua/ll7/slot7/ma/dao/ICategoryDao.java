package ua.ll7.slot7.ma.dao;

import org.springframework.data.repository.CrudRepository;
import ua.ll7.slot7.ma.model.CategoryForTheUser;

/**
 * @author Alex Velichko
 *         09.06.14 : 17:36
 */

/**
 * CategoryForTheUser-specific DAO-staff
 */
public interface ICategoryDao extends CrudRepository<CategoryForTheUser, Long> {

}
