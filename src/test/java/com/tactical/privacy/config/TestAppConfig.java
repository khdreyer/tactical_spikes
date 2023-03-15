package com.tactical.privacy.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestAppConfig {

    public AnnotationConfigApplicationContext getApplicationContext(){
        return new AnnotationConfigApplicationContext(
            DeleteStepConfig.class,
            CommonConfig.class,
            DeleteRunnerConfig.class,
            TestDeleteOrchestratorConfig.class

        );
    }
}