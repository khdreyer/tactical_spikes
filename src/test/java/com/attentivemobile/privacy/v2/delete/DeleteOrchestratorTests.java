package com.attentivemobile.privacy.v2.delete;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.attentivemobile.privacy.v2.delete.config.TestAppConfig;
import com.attentivemobile.privacy.v2.delete.orchestrator.DeleteOrchestrator;
import com.attentivemobile.privacy.v2.delete.steps.enums.DeleteStepStatus;
import com.attentivemobile.privacy.v2.delete.steps.enums.DeleteStepType;
import com.attentivemobile.privacy.v2.delete.steps.interfaces.DeleteStep;
import com.attentivemobile.privacy.v2.delete.steps.interfaces.DeleteStepResponse;
import com.attentivemobile.privacy.v2.delete.orchestrator.DeleteOrchestratorRequest;
import com.attentivemobile.privacy.v2.delete.orchestrator.UserIdentities;
import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DeleteOrchestratorTests {

    AnnotationConfigApplicationContext appContext;
    DeleteStep[] injectedSteps;
    DeleteOrchestrator orchestrator;

    public DeleteOrchestratorTests(){
        appContext = new TestAppConfig().getApplicationContext();
        orchestrator = appContext.getBean(DeleteOrchestrator.class);
        injectedSteps = appContext.getBean(DeleteStep[].class);
    }

    /**
     * Requesting a single valid step.
     * Only one step's response should be marked as processed.
     */
    @Test
    void skip_DeleteStep() {
        var validStepsFilter = new DeleteStepType[]{ DeleteStepType.IDENTITY_USER };
        var req = getRequestWithFilter(validStepsFilter);
        var response = orchestrator.process(req);
        int processedCount = 0;
        for (DeleteStepResponse stepResponse : response.getStepResults()){
            if (stepResponse.getStepStatus() == DeleteStepStatus.SUCCESS) {
                processedCount++;
            }
        }
        assertEquals(processedCount, 1);
    }

    /**
     * If the requested step types are not in the injected set throw
     * a not implemented exception.
     */
    @Test
    void throws_NotImplementedException() {
        assertThrows(
            NotImplementedException.class,
            () -> {
                var invalidStepsFilter = new DeleteStepType[]{ DeleteStepType.CARRIER_INFO };
                var req = getRequestWithFilter(invalidStepsFilter);
                orchestrator.process(req);
            });
    }

    private DeleteOrchestratorRequest getRequestWithFilter(DeleteStepType[] stepFilter) {
        return DeleteOrchestratorRequest.builder()
            .companyId(5L)
            .userIdentities(getTestIdentities())
            .stepFilter(stepFilter)
            .build();
    }

    private UserIdentities getTestIdentities() {
        return UserIdentities.builder()
            .phone("555-123-4567")
            .email("kaydray@gmail.com")
            .subscriberId(123L)
            .visitorId("TAKEMETOYOURLEADER")
            .build();
    }
}
