package com.tactical.privacy.config;

import com.tactical.privacy.PrivacyDeleteOrchestrator;
import com.tactical.privacy.interfaces.Orchestrator;
import com.tactical.privacy.interfaces.Step;
import com.tactical.privacy.repository.InMemoryPrivacyRequestRepository;
import com.tactical.privacy.steps.IdentityUserDeleteStep;
import com.tactical.privacy.steps.SubscriberMainMySqlDeleteStep;
import com.tactical.privacy.steps.ThirdPartyCustomerDeleteStep;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope(value = "prototype")
    public InMemoryPrivacyRequestRepository inMemoryPrivacyRequestRepository() {
        return new InMemoryPrivacyRequestRepository();
    }

    @Bean
    @Scope(value = "prototype")
    public Step getSubscriberMainMySqlDeleteStep() {
        return new SubscriberMainMySqlDeleteStep();
    }

    @Bean
    @Scope(value = "prototype")
    public Step getThirdPartyCustomerDeleteStep() {
        return new ThirdPartyCustomerDeleteStep();
    }

    @Bean
    @Scope(value = "prototype")
    public Step getIdentityUserDeleteStep() {
        return new IdentityUserDeleteStep();
    }

    @Bean
    @Scope(value = "prototype")
    public Orchestrator getOrchestrator() {
        return new PrivacyDeleteOrchestrator(getOrchestratorSteps());
    }

    public List<Step> getOrchestratorSteps() {
        var steps = new ArrayList<Step>();
        steps.add(getSubscriberMainMySqlDeleteStep());
        steps.add(getThirdPartyCustomerDeleteStep());
        steps.add(getIdentityUserDeleteStep());
        return steps;
    }
}