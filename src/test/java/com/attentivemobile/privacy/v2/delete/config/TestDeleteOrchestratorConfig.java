package com.attentivemobile.privacy.v2.delete.config;

import com.attentivemobile.privacy.v2.delete.orchestrator.DeleteOrchestrator;
import com.attentivemobile.privacy.v2.delete.steps.interfaces.DeleteStep;
import com.attentivemobile.privacy.v2.delete.steps.utils.DeleteStepValidator;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TestDeleteOrchestratorConfig {

    private final DeleteStepConfig deleteStepConfig;
    private final CommonConfig commonConfig;

    public TestDeleteOrchestratorConfig() {
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