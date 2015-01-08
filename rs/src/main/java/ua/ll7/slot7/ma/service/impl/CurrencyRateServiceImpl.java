package ua.ll7.slot7.ma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ll7.slot7.ma.model.CurrencyRate;
import ua.ll7.slot7.ma.repository.ICurrencyRateRepository;
import ua.ll7.slot7.ma.repository.custom.ICurrencyRateRepositoryCustom;
import ua.ll7.slot7.ma.service.ICurrencyRateService;

import java.util.List;

/**
 * @author velichko
 *         on 08.01.15 : 14:10
 */
@Service
public class CurrencyRateServiceImpl implements ICurrencyRateService {

  @Autowired
  private ICurrencyRateRepository currencyRateRepository;

  @Autowired
  private ICurrencyRateRepositoryCustom currencyRateRepositoryCustom;

  @Override
  public void save(CurrencyRate currencyRate) {
    currencyRateRepository.save(currencyRate);
  }

  @Override
  public List<CurrencyRate> getCurrencyRates(String c1, String c2) {
    return currencyRateRepository.getCurrencyRates(c1, c2);
  }

  @Override
  public float getCurrentCurrencyRate(String c1, String c2) {
    CurrencyRate currencyRate = currencyRateRepositoryCustom.getCurrentCurrencyRate(c1, c2);
    return currencyRate.getRate();
  }
}
