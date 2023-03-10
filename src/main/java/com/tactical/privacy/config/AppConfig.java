package com.tactical.privacy.config;

import com.tactical.privacy.services.ServiceRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ServiceRunner getServiceRunner(){
        return new ServiceRunner();
    }
}
