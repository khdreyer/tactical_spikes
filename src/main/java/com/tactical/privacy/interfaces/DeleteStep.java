package com.tactical.privacy.interfaces;

import com.tactical.privacy.models.DeleteStepType;

public interface DeleteStep {
    DeleteStepType getType();
    DeleteStepResponse process(DeleteStepRequest stepRequest);
}