package com.tactical.privacy.steps.utils;

import com.tactical.privacy.interfaces.DeleteStep;
import com.tactical.privacy.models.DeleteStepType;
import com.tactical.privacy.stats.Logger;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.NotImplementedException;

public class DeleteStepValidator {
    private static final Logger LOG = Logger.getLogger(DeleteStepValidator.class);

    public void throwIfInvalid(
        DeleteStep[] deleteSteps,
        DeleteStepType[] requestedStepTypes
    ) {
        if (!stepsAreUnique(deleteSteps)) {
            String msg = "Delete steps are not unique. More than one implementation exists for a given type.";
            var ex = new IllegalArgumentException(msg);
            LOG.error(msg, ex);
            throw ex;
        }

        if ((requestedStepTypes.length) > 0 && (invalidStepNameFound(deleteSteps, requestedStepTypes))) {
            String msg = "Unsupported step requested for processing.";
            var ex = new NotImplementedException(msg);
            LOG.error(msg, ex);
            throw ex;
        }
    }

    public boolean stepsAreUnique(DeleteStep[] steps) {
        Set<DeleteStepType> set = Arrays.stream(steps).map(DeleteStep::getType).collect(Collectors.toSet());
        if (set.size() == steps.length) {
            LOG.info(steps.length +  " unique delete steps found to process.");
            return true;
        } else {
            LOG.info(steps.length +  " unique delete steps found in the set of " + set.size());
            return false;
        }
    }

    private boolean invalidStepNameFound (DeleteStep[] deleteSteps, DeleteStepType[] requestedStepTypes) {
        var injectedStepTypes = Stream.of(deleteSteps).map(DeleteStep::getType).collect(Collectors.toSet());

        for (DeleteStepType requestedStepType : requestedStepTypes) {
            if (!injectedStepTypes.contains(requestedStepType)) {
                String msg = requestedStepType.toString() + " is not associated with any injected step";
                LOG.info(msg);
                return true;
            }
        }
        return false;
    }
}
