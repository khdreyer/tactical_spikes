package com.tactical.privacy.steps.utils;

import com.tactical.privacy.interfaces.DeleteStep;
import com.tactical.privacy.models.DeleteStepType;
import com.tactical.privacy.stats.Logger;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.NotImplementedException;

public class DeleteStepValidator {
    private static final Logger LOG = Logger.getLogger(DeleteStepValidator.class);

    public void throwIfInvalid(
        DeleteStep[] orchestratorSteps,
        DeleteStepType[] requestedSteps
    ) throws Exception {

        if (!stepsAreUnique(orchestratorSteps)) {
            String msg = "Delete steps are not unique. More than one type exists in the collection.";
            var ex = new Exception(msg);
            LOG.error(msg, ex);
            throw ex;
        }

        if ((requestedSteps.length) > 0 && (invalidStepNameFound(orchestratorSteps, requestedSteps))) {
            String msg = "Unsupported step requested for processing.";
            var ex = new NotImplementedException(msg);
            LOG.error(msg, ex);
            throw ex;
        }
    }

    public boolean stepsAreUnique(DeleteStep[] orchestratorSteps) {
        Set<DeleteStepType> set = Arrays.stream(orchestratorSteps).map(DeleteStep::getType).collect(Collectors.toSet());
        if (set.size() == orchestratorSteps.length) {
            LOG.info(orchestratorSteps.length +  " unique delete steps found to process.");
            return true;
        } else {
            LOG.info(orchestratorSteps.length +  " unique delete steps found in the set of " + set.size());
            return false;
        }
    }

    private boolean invalidStepNameFound (DeleteStep[] supportedSteps, DeleteStepType[] requestedSteps) {
        var supportedTypes = Arrays.stream(supportedSteps).map(DeleteStep::getType).collect(Collectors.toSet());
        for (DeleteStepType requestedStep : requestedSteps) {
            if (!supportedTypes.contains(requestedStep)) {
                String msg = "Unsupported step requested for processing. -> " + requestedStep.toString();
                LOG.warn(msg);
                return false;
            }
        }
        return true;
    }
}
