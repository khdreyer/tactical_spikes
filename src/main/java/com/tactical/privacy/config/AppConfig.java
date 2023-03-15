package com.tactical.privacy.config;

import com.tactical.privacy.DeleteOrchestrator;
import com.tactical.privacy.DeleteRequestTransformer;
import com.tactical.privacy.helpers.ObjectSerializer;
import com.tactical.privacy.interfaces.DeleteStep;
import com.tactical.privacy.reporting.DeleteReportBuilder;
import com.tactical.privacy.repos.MockPrivacyRepository;
import com.tactical.privacy.repos.PrivacyRepository;
import com.tactical.privacy.services.DeleteRunner;
import com.tactical.privacy.services.IdentityService;
import com.tactical.privacy.steps.utils.DeleteStepConvertor;
import com.tactical.privacy.steps.utils.DeleteStepValidator;
import com.tactical.privacy.steps.IdentityUserDeleteStep;
import com.tactical.privacy.steps.SubscriberMainMySqlDeleteStep;
import com.tactical.privacy.steps.ThirdPartyCustomerDeleteStep;
import java.util.ArrayList;
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
            getDeleteStepValidator(),
            getSerializer()
        );
    }

    @Bean
    @Scope(value = "prototype")
    public DeleteRunner getDeleteRunner() {
        return new DeleteRunner(
            getRequestTransformer(),
            getDeleteOrchestrator(),
            getReportBuilder(),
            getPrivacyRepo()
        );
    }

    @Bean
    @Scope(value = "prototype")
    public DeleteRequestTransformer getRequestTransformer(){
        return new DeleteRequestTransformer(
            getDeleteStepConverter(),
            getIdentityService());
    }


    public DeleteStep[] getOrchestratorSteps() {
        var steps = new ArrayList<DeleteStep>();
        steps.add(getSubscriberMainMySqlDeleteStep());
        steps.add(getThirdPartyCustomerDeleteStep());
        steps.add(getIdentityUserDeleteStep());
        return steps.toArray(DeleteStep[]::new);
    }

    @Bean
    public ObjectSerializer getSerializer(){
        return new ObjectSerializer();
    }

    @Bean
    @Scope(value = "prototype")
    public DeleteRequestTransformer getPrivacyDeleteRequestBuilder(){
        return new DeleteRequestTransformer(
            getDeleteStepConverter(),
            getIdentityService()
        );
    }

    @Scope(value = "prototype")
    public IdentityService getIdentityService() {
        return new IdentityService();
    }

    @Bean
    @Scope(value = "prototype")
    public DeleteReportBuilder getReportBuilder() { return new DeleteReportBuilder(); }

    @Bean
    @Scope(value = "prototype")
    public DeleteStepConvertor getDeleteStepConverter() {
        return new DeleteStepConvertor();
    }

    @Bean
    public PrivacyRepository getPrivacyRepo() {
        return new MockPrivacyRepository(getSerializer());
    }

    @Bean
    public DeleteStepValidator getDeleteStepValidator() {
        return new DeleteStepValidator();
    }

}