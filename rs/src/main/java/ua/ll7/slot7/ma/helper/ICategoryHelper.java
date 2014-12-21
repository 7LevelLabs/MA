package ua.ll7.slot7.ma.helper;

import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.User;

/**
 * @author Alex Velichko
 *         10.06.14 : 14:37
 */
@Component
public interface ICategoryHelper {
	public CategoryForTheUser getNewCategory(User user,
				   String name,
				   String description);
}
