package com.tactical.privacy.steps.utils;

import com.tactical.privacy.models.DeleteStepType;
import com.tactical.privacy.stats.Logger;
import java.util.ArrayList;

public class DeleteStepConvertor {

    private static final Logger LOG = Logger.getLogger(DeleteStepConvertor.class);

    public DeleteStepType[] tryConvert(String[] deleteSteps) {
        String stepForLogging = "NOT_SET";
        try {
            var types = new ArrayList<DeleteStepType>();
            for (String step : deleteSteps) {
                stepForLogging = step;
                DeleteStepType type = DeleteStepType.valueOf(step);
                types.add(type);
            }
            return types.toArray(DeleteStepType[]::new);
        } catch (Exception ex) {
            var msg = "Invalid steps filter provided! \"" + stepForLogging + "\" is not a valid delete step.";
            LOG.error(msg, ex);
            throw ex;
        }
    }
}