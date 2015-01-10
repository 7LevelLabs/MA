package ua.ll7.slot7.ma.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.actor.IServiceActor;

/**
 * @author velichko
 *         on 10.01.15 : 16:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:maTestConf/maConfigTest.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class AkkaTest {

  @Autowired
  private IServiceActor serviceActor;

  @Test
  public void testTestProcessData() {
    serviceActor.processData("Ku-ku");

  }

}
