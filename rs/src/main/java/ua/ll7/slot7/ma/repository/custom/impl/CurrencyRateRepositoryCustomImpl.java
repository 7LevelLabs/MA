package ua.ll7.slot7.ma.repository.custom.impl;

import org.springframework.stereotype.Repository;
import ua.ll7.slot7.ma.model.CurrencyRate;
import ua.ll7.slot7.ma.repository.custom.ICurrencyRateRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author velichko
 *         on 08.01.15 : 14:51
 */
@Repository
public class CurrencyRateRepositoryCustomImpl implements ICurrencyRateRepositoryCustom {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public CurrencyRate getCurrentCurrencyRate(String c1, String c2) {
    return (CurrencyRate) getEntityManager()
           .createQuery("select cr from CurrencyRate cr where cr.currencyCode1 = ?1 and cr.currencyCode2 = ?2 order by cr.registered desc")
           .setParameter(1, c1)
           .setParameter(2, c2)
           .setMaxResults(1)
           .getSingleResult();
  }

  private EntityManager getEntityManager() {
    return entityManager;
  }
}
