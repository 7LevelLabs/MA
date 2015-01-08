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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:maTestConf/maConfigTest.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class CurrencyRateServiceImplTest {

  @Autowired
  private ICurrencyRateService currencyRateService;

  @Test
  public void testGetCurrencyRates() throws Exception {
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

    CurrencyRate cr4 = MAFactory.getNewCurrencyRateFS("USD",
                                                      "EUR",
                                                      0.8F);

    currencyRateService.save(cr4);

    List<CurrencyRate> currencyRateList = currencyRateService.getCurrencyRates("USD",
                                                                               "UAH");

    org.assertj.core.api.Assertions.assertThat(currencyRateList)
           .isNotEmpty()
           .hasSize(3)
           .contains(cr1, cr2, cr3)
    ;

    assertTrue(currencyRateList.get(0).getRegistered().getTime()
                      >
                      currencyRateList.get(1).getRegistered().getTime());

    assertTrue(currencyRateList.get(1).getRegistered().getTime()
                      >
                      currencyRateList.get(2).getRegistered().getTime());

    org.assertj.core.api.Assertions.assertThat(currencyRateService.getCurrencyRates("USD",
                                                                                    "EUR"))
           .isNotEmpty()
           .hasSize(1)
           .contains(cr4)
    ;
  }

  @Test
  public void testGetCurrentCurrencyRate() throws Exception {
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

    float crLast = currencyRateService.getCurrentCurrencyRate("USD",
                                                              "UAH").getRate();

    assertEquals(crLast, 18.51F, 0.0001F);

  }
}