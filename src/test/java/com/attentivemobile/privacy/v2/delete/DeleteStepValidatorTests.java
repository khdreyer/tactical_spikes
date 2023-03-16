package com.attentivemobile.privacy.v2.delete;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.attentivemobile.privacy.v2.delete.config.DeleteStepConfig;
import com.attentivemobile.privacy.v2.delete.steps.enums.DeleteStepType;
import com.attentivemobile.privacy.v2.delete.steps.interfaces.DeleteStep;
import com.attentivemobile.privacy.v2.delete.steps.utils.DeleteStepValidator;
import com.attentivemobile.privacy.v2.delete.config.TestAppConfig;
import java.util.ArrayList;
import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DeleteStepValidatorTests {

    AnnotationConfigApplicationContext appContext;
    DeleteStep[] injectedSteps;
    DeleteStepValidator validator;

    public DeleteStepValidatorTests(){
        appContext = new TestAppConfig().getApplicationContext();
        validator = appContext.getBean(DeleteStepValidator.class);
        injectedSteps = appContext.getBean(DeleteStep[].class);
    }

    /**
     * Proper set up. No throw.
     */
    @Test
    void no_throw_DeleteStepConfig() {
        var stepTypes = new DeleteStepType[] {};
        validator.throwIfInvalid(injectedSteps, stepTypes);
    }

    /**
     * If at runtime the orchestrator finds more than one step of a
     * given type an exception should be thrown.
     */
    @Test
    void throws_NotImplementedException() {
        //
        // given type an exception should be thrown
        assertThrows(
            IllegalArgumentException.class,
            () -> {
                var deleteStepConfig = new DeleteStepConfig();
                var steps = new ArrayList<DeleteStep>();
                steps.add(deleteStepConfig.getSubscriberMainMySqlDeleteStep());
                steps.add(deleteStepConfig.getSubscriberMainMySqlDeleteStep());
                var injectedStepsOverride = steps.toArray(DeleteStep[]::new);
                var stepTypes = new DeleteStepType[] { DeleteStepType.CARRIER_INFO, DeleteStepType.CARRIER_INFO };
                validator.throwIfInvalid(injectedStepsOverride, stepTypes);
            });
    }

    /**
     * If the requested step types are not in the injected set throw an exception.
     */
    @Test
    void throws_IllegalArgumentException() {
        assertThrows(
            NotImplementedException.class,
            () -> {
                var stepTypes = new DeleteStepType[] { DeleteStepType.SUBSCRIBER_GEOLOCATION };
                validator.throwIfInvalid(injectedSteps, stepTypes);
            });
    }
}
