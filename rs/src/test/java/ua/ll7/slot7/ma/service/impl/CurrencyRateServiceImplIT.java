package ua.ll7.slot7.ma.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.model.CurrencyRate;
import ua.ll7.slot7.ma.service.ICurrencyRateService;
import ua.ll7.slot7.ma.util.MAFactory;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:maTestConf/maConfigIT.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class CurrencyRateServiceImplIT {

  @Autowired
  private ICurrencyRateService currencyRateService;

  @Test
  public void testCaching() throws Exception {
    CurrencyRate cr1 = MAFactory.getNewCurrencyRateFS("USD",
                                                      "UAH",
                                                      17.01F);

    currencyRateService.save(cr1);

    Thread.sleep(3000);

    CurrencyRate cr2 = MAFactory.getNewCurrencyRateFS("USD",
                                                      "UAH",
                                                      18.01F);

    currencyRateService.save(cr2);

    Thread.sleep(3000);

    CurrencyRate cr3 = MAFactory.getNewCurrencyRateFS("USD",
                                                      "UAH",
                                                      18.51F);

    currencyRateService.save(cr3);

    long current = System.currentTimeMillis();

    List<CurrencyRate> rates1 = currencyRateService.getCurrencyRates("USD", "UAH");

    long current1 = System.currentTimeMillis();

    List<CurrencyRate> rates2 = currencyRateService.getCurrencyRates("USD", "UAH");

    long current2 = System.currentTimeMillis();

    List<CurrencyRate> rates3 = currencyRateService.getCurrencyRates("USD", "UAH");

    long current3 = System.currentTimeMillis();

    CurrencyRate cr4 = MAFactory.getNewCurrencyRateFS("USD",
                                                      "UAH",
                                                      18.51F);

    currencyRateService.save(cr4);

    List<CurrencyRate> rates4 = currencyRateService.getCurrencyRates("USD", "UAH");

    long current4 = System.currentTimeMillis();

    System.out.println(current);
    System.out.println(current1);
    System.out.println(current2);
    System.out.println(current3);
    System.out.println(current4);

  }
}