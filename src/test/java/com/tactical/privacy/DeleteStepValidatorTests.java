package com.tactical.privacy;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.tactical.privacy.config.DeleteStepConfig;
import com.tactical.privacy.config.TestAppConfig;
import com.tactical.privacy.interfaces.DeleteStep;
import com.tactical.privacy.steps.enums.DeleteStepType;
import com.tactical.privacy.steps.utils.DeleteStepValidator;
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

    @Test
    void no_throw_DeleteStepConfig() {
        var stepTypes = new DeleteStepType[] {};
        validator.throwIfInvalid(injectedSteps, stepTypes);
    }

    @Test
    void throws_NotImplementedException() {
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
