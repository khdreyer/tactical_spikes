package com.tactical.privacy.interfaces;

import com.tactical.privacy.models.PrivacyDeleteStepType;

public interface Step {
    PrivacyDeleteStepType getType();
    StepResponse process(StepRequest stepRequest);
    void process();

}