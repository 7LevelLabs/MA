package ua.ll7.slot7.ma.metrics;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.codahale.metrics.jvm.GarbageCollectorMetricSet;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;
import com.codahale.metrics.jvm.ThreadStatesGaugeSet;

/**
 * MA
 * Velichko A.
 * 29.12.14 17:38
 */
public class MetricsManager {
  private static final MetricRegistry      METRIC_REGISTRY       = new MetricRegistry();
  private static final HealthCheckRegistry HEALTH_CHECK_REGISTRY = new HealthCheckRegistry();

  static {
    METRIC_REGISTRY.registerAll(new GarbageCollectorMetricSet());
    METRIC_REGISTRY.registerAll(new MemoryUsageGaugeSet());
    METRIC_REGISTRY.registerAll(new ThreadStatesGaugeSet());
  }

  public static MetricRegistry getMetricRegistry() {
    return METRIC_REGISTRY;
  }

  public static HealthCheckRegistry getHealthCheckRegistry() {
    return HEALTH_CHECK_REGISTRY;
  }
}
