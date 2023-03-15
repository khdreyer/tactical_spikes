package com.tactical.privacy.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    public AnnotationConfigApplicationContext getApplicationContext(){
        return new AnnotationConfigApplicationContext(
            CommonConfig.class,
            DeleteRunnerConfig.class,
            DeleteOrchestratorConfig.class,
            DeleteStepConfig.class
        );
    }
}