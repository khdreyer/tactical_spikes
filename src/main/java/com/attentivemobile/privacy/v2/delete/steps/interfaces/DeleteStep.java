package com.attentivemobile.privacy.v2.delete.steps.interfaces;

import com.attentivemobile.privacy.v2.delete.steps.enums.DeleteStepType;

public interface DeleteStep {
    DeleteStepType getType();
    DeleteStepResponse process(DeleteStepRequest stepRequest);
    DeleteStepResponse skip(DeleteStepRequest stepRequest);

}