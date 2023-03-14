package com.tactical.privacy.steps;

import com.tactical.privacy.interfaces.DeleteStep;
import com.tactical.privacy.models.DeleteStepType;
import com.tactical.privacy.stats.Logger;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DeleteStepValidator {
    private static final Logger LOG = Logger.getLogger(DeleteStepValidator.class);

    public void throwIfInvalid(List<DeleteStep> steps) throws Exception {
        if (!stepsAreUnique(steps)) {
            String msg = "Delete steps are not unique. More than one type exists in the collection.";
            var ex = new Exception(msg);
            LOG.error(msg, ex);
            throw ex;
        }
    }

    boolean stepsAreUnique(List<DeleteStep> steps) {
        Set<DeleteStepType> set = steps.stream().map(DeleteStep::getType).collect(Collectors.toSet());
        if (set.size() == steps.size()) {
            LOG.info(steps.size() +  " unique delete steps found to process.");
            return true;
        } else {
            LOG.info(steps.size() +  " unique delete steps found in the set of " + set.size());
            return false;
        }
    }
}
