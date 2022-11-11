package org.prom.engine;

import org.junit.jupiter.api.Test;
import org.prom.engine.configuration.ConfigurationProperties;
import org.prom.engine.configuration.ExternalConfiguration;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ExternalConfigurationTest {
    private static final ConfigurationProperties configurationProperties =
            ExternalConfiguration.getInstance().getConfigurationProperties();

    @Test
    public void testConfig() {
        assertFalse(configurationProperties.getProducts().isEmpty());
    }
}
