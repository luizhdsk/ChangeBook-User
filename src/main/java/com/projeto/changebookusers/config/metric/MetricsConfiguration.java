package com.projeto.changebookusers.config.metric;

import com.grcosta.messagelocator.interfaces.MessageService;
import com.grcosta.messagelocator.service.EnvironmentMessageService;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MetricsConfiguration {

    MeterRegistryCustomizer<MeterRegistry> registerCommonTags(Environment environment) {
        final String applicationName = environment.getProperty("spring.application.name");
        return registry -> registry.config().commonTags(
                "app_name", applicationName,
                "env", environment.getActiveProfiles()[0])
                .namingConvention(new MetricsNamingConvention(applicationName));
    }

    @Bean
    public MessageService createMessageService(MeterRegistry meterRegistry) {
        return new EnvironmentMessageService(meterRegistry);
    }

}
