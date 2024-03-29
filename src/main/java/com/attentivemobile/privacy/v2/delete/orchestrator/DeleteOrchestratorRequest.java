package com.attentivemobile.privacy.v2.delete.orchestrator;

import com.attentivemobile.privacy.v2.delete.steps.enums.DeleteStepType;
import org.immutables.value.Value;

@Value.Immutable
public interface DeleteOrchestratorRequest {
    static Builder builder() {
        return ImmutableDeleteOrchestratorRequest.builder();
    }

    long getCompanyId();

    UserIdentities getUserIdentities();

    @Value.Default
    default DeleteStepType[] getStepFilter()  {
        return new DeleteStepType[] {};
    }

    interface Builder {
        Builder companyId(long companyId);

        Builder userIdentities(UserIdentities userIdentities);

        Builder stepFilter(DeleteStepType[] steps);

        DeleteOrchestratorRequest build();
    }
}
