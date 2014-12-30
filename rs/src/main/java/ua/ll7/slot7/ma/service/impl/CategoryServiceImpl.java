package ua.ll7.slot7.ma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.repository.ICategoryDao;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.ICategoryService;

import java.util.List;

/**
 * @author Alex Velichko
 *         10.06.14 : 14:50
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CategoryServiceImpl implements ICategoryService {

  @Autowired
  private ICategoryDao dao;

  @Override
  public void save(CategoryForTheUser toSave) {
    dao.save(toSave);
  }

  @Override
  public boolean existCategoryByName(User user, String categoryNameToCheck) {
    CategoryForTheUser categoryForTheUser = new CategoryForTheUser();
    categoryForTheUser.setUser(user);
    categoryForTheUser.setName(categoryNameToCheck);
    return user.getCategories().contains(categoryForTheUser);
  }

  @Override
  public CategoryForTheUser findByUserAndName(User user, String categoryName) {
    return dao.findByUserAndName(user, categoryName);
  }

  @Override
  public List<CategoryForTheUser> findByUser(User user) {
    return dao.findByUser(user);
  }
}
