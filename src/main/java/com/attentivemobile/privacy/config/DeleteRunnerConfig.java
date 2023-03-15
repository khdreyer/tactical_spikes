package com.attentivemobile.privacy.config;

import com.attentivemobile.privacy.DeleteRequestTransformer;
import com.attentivemobile.privacy.reporting.DeleteReportBuilder;
import com.attentivemobile.privacy.repos.MockPrivacyRepository;
import com.attentivemobile.privacy.repos.PrivacyRepository;
import com.attentivemobile.privacy.services.DeleteRunner;
import com.attentivemobile.privacy.services.IdentityService;
import com.attentivemobile.privacy.steps.utils.DeleteStepConvertor;
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