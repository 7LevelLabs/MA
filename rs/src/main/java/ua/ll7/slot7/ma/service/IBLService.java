package ua.ll7.slot7.ma.service;

import org.springframework.stereotype.Service;
import ua.ll7.slot7.ma.exception.AppDataIntegrityException;
import ua.ll7.slot7.ma.exception.AppEntityNotFoundException;
import ua.ll7.slot7.ma.model.Category;
import ua.ll7.slot7.ma.model.User;

/**
 * @author Alex Velichko
 *         10.06.14 : 15:26
 */
@Service
public interface IBLService {

	public User userFind(long id) throws AppEntityNotFoundException;

	//Category
	public Category categoryCreate(long userId, String categoryName, String categoryDescription) throws AppEntityNotFoundException, AppDataIntegrityException;

}
