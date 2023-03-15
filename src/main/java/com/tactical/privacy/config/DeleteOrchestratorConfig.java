package com.tactical.privacy.config;

import com.tactical.privacy.DeleteOrchestrator;
import com.tactical.privacy.interfaces.DeleteStep;
import com.tactical.privacy.steps.utils.DeleteStepValidator;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DeleteOrchestratorConfig {

    private final DeleteStepConfig deleteStepConfig;
    private final CommonConfig commonConfig;

    public DeleteOrchestratorConfig() {
        deleteStepConfig = new DeleteStepConfig();
        commonConfig = new CommonConfig();
    }

    @Bean
    @Scope(value = "prototype")
    public DeleteOrchestrator getDeleteOrchestrator() {
        return new DeleteOrchestrator(
            getOrchestratorSteps(),
            getDeleteStepValidator(),
            commonConfig.getSerializer()
        );
    }

    @Bean
    public DeleteStep[] getOrchestratorSteps() {
        var steps = new ArrayList<DeleteStep>();
        steps.add(deleteStepConfig.getSubscriberMainMySqlDeleteStep());
        steps.add(deleteStepConfig.getThirdPartyCustomerDeleteStep());
        steps.add(deleteStepConfig.getIdentityUserDeleteStep());
        return steps.toArray(DeleteStep[]::new);
    }

    @Bean
    public DeleteStepValidator getDeleteStepValidator() {
        return new DeleteStepValidator();
    }
}