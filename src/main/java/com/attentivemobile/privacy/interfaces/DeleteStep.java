package com.attentivemobile.privacy.interfaces;

import com.attentivemobile.privacy.steps.enums.DeleteStepType;

public interface DeleteStep {
    DeleteStepType getType();
    DeleteStepResponse process(DeleteStepRequest stepRequest);
    DeleteStepResponse skip(DeleteStepRequest stepRequest);

}