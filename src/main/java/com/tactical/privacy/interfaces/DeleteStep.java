package com.tactical.privacy.interfaces;

import com.tactical.privacy.steps.enums.DeleteStepType;

public interface DeleteStep {
    DeleteStepType getType();
    DeleteStepResponse process(DeleteStepRequest stepRequest);
    DeleteStepResponse skip(DeleteStepRequest stepRequest);

}