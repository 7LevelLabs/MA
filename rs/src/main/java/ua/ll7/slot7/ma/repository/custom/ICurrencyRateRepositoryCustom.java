package ua.ll7.slot7.ma.repository.custom;

import ua.ll7.slot7.ma.model.CurrencyRate;

/**
 * @author velichko
 *         on 08.01.15 : 14:36
 */
public interface ICurrencyRateRepositoryCustom {

  public CurrencyRate getCurrentCurrencyRate(String c1, String c2);
}
