package com.tactical.privacy.config;

import com.tactical.privacy.DeleteRequestTransformer;
import com.tactical.privacy.reporting.DeleteReportBuilder;
import com.tactical.privacy.repos.MockPrivacyRepository;
import com.tactical.privacy.repos.PrivacyRepository;
import com.tactical.privacy.services.DeleteRunner;
import com.tactical.privacy.services.IdentityService;
import com.tactical.privacy.steps.utils.DeleteStepConvertor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DeleteRunnerConfig {

    private final DeleteOrchestratorConfig orchestratorConfig;
    private final CommonConfig commonConfig;

    public DeleteRunnerConfig() {
        orchestratorConfig = new DeleteOrchestratorConfig();
        commonConfig = new CommonConfig();
    }

    @Bean
    @Scope(value = "prototype")
    public DeleteRunner getDeleteRunner() {
        return new DeleteRunner(
            getRequestTransformer(),
            orchestratorConfig.getDeleteOrchestrator(),
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

    @Bean
    @Scope(value = "prototype")
    public DeleteReportBuilder getReportBuilder() { return new DeleteReportBuilder(); }

    @Bean
    public PrivacyRepository getPrivacyRepo() {
        return new MockPrivacyRepository(commonConfig.getSerializer());
    }

    @Scope(value = "prototype")
    public IdentityService getIdentityService() {
        return new IdentityService();
    }

    @Bean
    @Scope(value = "prototype")
    public DeleteStepConvertor getDeleteStepConverter() {
        return new DeleteStepConvertor();
    }
}