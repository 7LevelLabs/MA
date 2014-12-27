package ua.ll7.slot7.ma.magic.dao;

import ua.ll7.slot7.ma.model.User;

import java.util.List;

/**
 * MA
 * Velichko A.
 * 27.12.14 10:47
 */
public interface IUserMagicRepository {
  public void create(User systemUser);

  public List<User> getAll();
}
