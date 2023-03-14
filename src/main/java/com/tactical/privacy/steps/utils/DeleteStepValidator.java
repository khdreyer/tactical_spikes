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
        DeleteStep[] injectedSteps,
        DeleteStepType[] requestedStepTypes
    ) throws Exception {

        if (!stepsAreUnique(injectedSteps)) {
            String msg = "Delete steps are not unique. More than one type exists in the collection.";
            var ex = new Exception(msg);
            LOG.error(msg, ex);
            throw ex;
        }

        if ((requestedStepTypes.length) > 0 && (invalidStepNameFound(injectedSteps, requestedStepTypes))) {
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

    private boolean invalidStepNameFound (DeleteStep[] injectedSteps, DeleteStepType[] requestedStepTypes) {
        var injectedStepTypes = Stream.of(injectedSteps).map(DeleteStep::getType).collect(Collectors.toSet());

        for (DeleteStepType requestedStepType : requestedStepTypes) {
            if (!injectedStepTypes.contains(requestedStepType)) {
                String msg = "Unsupported step requested for processing. -> " + requestedStepType.toString();
                LOG.warn(msg);
                return true;
            }
        }
        return false;
    }
}
