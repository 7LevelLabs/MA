package ua.ll7.slot7.ma.magic.service.impl;

import ua.ll7.slot7.ma.magic.dao.IUserMagicRepository;
import ua.ll7.slot7.ma.magic.dao.impl.UserMagicRepositoryImpl;
import ua.ll7.slot7.ma.magic.service.IUserMagicService;
import ua.ll7.slot7.ma.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * MA
 * Velichko A.
 * 27.12.14 10:56
 */
public class UserMagicServiceImpl implements IUserMagicService {

  private EntityManagerFactory emf;
  private EntityManager        em;

  private IUserMagicRepository repository;

  public UserMagicServiceImpl() {
    emf = Persistence.createEntityManagerFactory("maMagicUnit");
    em = emf.createEntityManager();
    repository = new UserMagicRepositoryImpl(em);
  }

  @Override
  public void create(User user) {
    repository.create(user);
  }

  @Override
  public int count() {
    return repository.getAll().size();
  }
}
