package com.tactical.privacy.config;

import com.tactical.privacy.orchestrator.OrchestratorImpl;
import com.tactical.privacy.orchestrator.interfaces.Orchestrator;
import com.tactical.privacy.repository.InMemoryPrivacyRequestRepository;
import com.tactical.privacy.services.ServiceRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ServiceRunner getServiceRunner(){
        return new ServiceRunner();
    }

    @Bean
    public InMemoryPrivacyRequestRepository inMemoryPrivacyRequestRepository(){
        return new InMemoryPrivacyRequestRepository();
    }

    @Bean
    public OrchestratorImpl orchestrator() {
        return new OrchestratorImpl();
    }

}
