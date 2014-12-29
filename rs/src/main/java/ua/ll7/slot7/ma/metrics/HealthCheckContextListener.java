package ua.ll7.slot7.ma.metrics;

import com.codahale.metrics.health.HealthCheckRegistry;
import com.codahale.metrics.servlets.HealthCheckServlet;

/**
 * MA
 * Velichko A.
 * 29.12.14 17:42
 */
public class HealthCheckContextListener extends HealthCheckServlet.ContextListener {

  @Override
  protected HealthCheckRegistry getHealthCheckRegistry() {
    return MetricsManager.getHealthCheckRegistry();
  }
}
