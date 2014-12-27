package ua.ll7.slot7.ma.magic.dao.impl;

import ua.ll7.slot7.ma.magic.dao.AJPARepository;
import ua.ll7.slot7.ma.magic.dao.IUserMagicRepository;
import ua.ll7.slot7.ma.model.User;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * MA
 * Velichko A.
 * 27.12.14 10:49
 */
public class UserMagicRepositoryImpl extends AJPARepository implements IUserMagicRepository {

  protected UserMagicRepositoryImpl(EntityManager entityManager) {
    super(entityManager);
  }

  @Override
  public void create(User user) {
    getEntityManager().getTransaction().begin();
    getEntityManager().persist(user);
    getEntityManager().getTransaction().commit();
  }

  @Override
  public List<User> getAll() {
    return getEntityManager()
                         .createQuery("select u from User u", User.class)
                         .getResultList();
  }
}
