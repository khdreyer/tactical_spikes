package com.tactical.privacy.interfaces;

import com.tactical.privacy.models.StepType;

public interface Step {
    StepType getType();
    StepResponse process(StepRequest stepRequest);
    void process();

}