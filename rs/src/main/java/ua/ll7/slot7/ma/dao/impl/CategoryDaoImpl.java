package ua.ll7.slot7.ma.dao.impl;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ua.ll7.slot7.ma.dao.ADao;
import ua.ll7.slot7.ma.dao.ICategoryDao;
import ua.ll7.slot7.ma.model.Category;

/**
 * @author Alex Velichko
 *         09.06.14 : 18:00
 */
@Repository
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CategoryDaoImpl extends ADao<Category> implements ICategoryDao {

}
