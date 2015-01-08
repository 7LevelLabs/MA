package ua.ll7.slot7.ma.service;

import ua.ll7.slot7.ma.model.CurrencyRate;

import java.util.List;

/**
 * @author velichko
 *         on 08.01.15 : 14:09
 */
public interface ICurrencyRateService {

  public void save(CurrencyRate currencyRate);

  public List<CurrencyRate> getCurrencyRates(String c1, String c2);

  public CurrencyRate getCurrentCurrencyRate(String c1, String c2);
}
