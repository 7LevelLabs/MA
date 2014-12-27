package ua.ll7.slot7.ma.ticker.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.ticker.ITickerService;

/**
 * MA
 * Velichko A.
 * 27.12.14 12:29
 */
@Component
public class TickerServiceImpl implements ITickerService {

  private static final Logger LOGGER = Logger.getLogger(TickerServiceImpl.class);

  @Override
  public void processNextAction() {
    LOGGER.debug("Next action : empty");

  }
}
