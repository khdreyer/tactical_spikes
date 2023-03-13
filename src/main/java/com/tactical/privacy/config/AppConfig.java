package com.tactical.privacy.config;

import com.tactical.privacy.DeleteOrchestrator;
import com.tactical.privacy.DeleteRequestEnricher;
import com.tactical.privacy.helpers.ObjectSerializer;
import com.tactical.privacy.interfaces.DeleteStep;
import com.tactical.privacy.repos.MockPrivacyRepository;
import com.tactical.privacy.repos.PrivacyRepository;
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
    public DeleteStep getSubscriberMainMySqlDeleteStep() {
        return new SubscriberMainMySqlDeleteStep();
    }

    @Bean
    @Scope(value = "prototype")
    public DeleteStep getThirdPartyCustomerDeleteStep() {
        return new ThirdPartyCustomerDeleteStep();
    }

    @Bean
    @Scope(value = "prototype")
    public DeleteStep getIdentityUserDeleteStep() {
        return new IdentityUserDeleteStep();
    }

    @Bean
    @Scope(value = "prototype")
    public DeleteOrchestrator getDeleteOrchestrator() {
        return new DeleteOrchestrator(
            getOrchestratorSteps(),
            getSerializer()
        );
    }

    public List<DeleteStep> getOrchestratorSteps() {
        var steps = new ArrayList<DeleteStep>();
        steps.add(getSubscriberMainMySqlDeleteStep());
        steps.add(getThirdPartyCustomerDeleteStep());
        steps.add(getIdentityUserDeleteStep());
        return steps;
    }

    @Bean
    public ObjectSerializer getSerializer(){
        return new ObjectSerializer();
    }

    @Bean
    @Scope(value = "prototype")
    public DeleteRequestEnricher getPrivacyDeleteRequestBuilder(){
        return new DeleteRequestEnricher();
    }

    @Bean
    public PrivacyRepository getPrivacyRepo() {
        return new MockPrivacyRepository();
    }
}