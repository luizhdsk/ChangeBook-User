package com.projeto.changebookusers.config.metric;

import io.micrometer.core.instrument.Meter.Type;
import io.micrometer.prometheus.PrometheusNamingConvention;

public class MetricsNamingConvention extends PrometheusNamingConvention {

    private final String applicationName;

    public MetricsNamingConvention(String applicationName) {
        super();
        this.applicationName = applicationName;
    }

    public String name(String name, Type type, String baseUnit) {
        return super.name(applicationName + "_" + name, type, baseUnit);
    }
}
