package ua.ll7.slot7.ma.metrics;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlets.MetricsServlet;

/**
 * MA
 * Velichko A.
 * 29.12.14 17:36
 */
public class MetricsContextListener extends MetricsServlet.ContextListener {

  @Override
  protected MetricRegistry getMetricRegistry() {
    return MetricsManager.getMetricRegistry();
  }
}
