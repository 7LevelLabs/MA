package ua.ll7.slot7.ma.service;

import ua.ll7.slot7.ma.exception.AppDataIntegrityException;
import ua.ll7.slot7.ma.exception.AppEntityNotFoundException;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.User;

/**
 * @author Alex Velichko
 *         10.06.14 : 15:26
 */
public interface IBLService {
	//CategoryForTheUser
	public CategoryForTheUser categoryCreate(User user, String categoryName, String categoryDescription) throws AppEntityNotFoundException, AppDataIntegrityException;

}
