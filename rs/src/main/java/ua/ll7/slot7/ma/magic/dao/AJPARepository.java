package ua.ll7.slot7.ma.magic.dao;

import javax.persistence.EntityManager;

/**
 * MA
 * Velichko A.
 * 27.12.14 10:46
 */
public abstract class AJPARepository {
  private EntityManager entityManager;

  protected AJPARepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public EntityManager getEntityManager() {
    return entityManager;
  }

  public void setEntityManager(EntityManager entityManager) {
    this.entityManager = entityManager;
  }
}
