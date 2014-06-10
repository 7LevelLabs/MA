package ua.ll7.slot7.ma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.dao.impl.CategoryDaoImpl;
import ua.ll7.slot7.ma.model.Category;
import ua.ll7.slot7.ma.service.AService;
import ua.ll7.slot7.ma.service.ICategoryService;

/**
 * @author Alex Velichko
 *         10.06.14 : 14:50
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CategoryServiceImpl extends AService<Category> implements ICategoryService  {

	@Autowired
	public void setDao(CategoryDaoImpl daoToSet) {
		this.dao = daoToSet;
		daoToSet.setClazz(Category.class);
	}

}
