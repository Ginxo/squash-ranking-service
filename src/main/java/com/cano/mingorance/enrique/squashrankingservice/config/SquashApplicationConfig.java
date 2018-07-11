package com.cano.mingorance.enrique.squashrankingservice.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Squash application config.
 */
@Configuration
public class SquashApplicationConfig {

    /**
     * Gets dozer bean mapper.
     *
     * @return the dozer bean mapper
     */
    @Bean
    public DozerBeanMapper getDozerBeanMapper() {
        return new DozerBeanMapper();
    }
}
