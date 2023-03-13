package com.tactical.privacy;

import com.tactical.privacy.helpers.ObjectSerializer;
import com.tactical.privacy.interfaces.DeleteOrchestratorRequest;
import com.tactical.privacy.interfaces.DeleteOrchestratorResponse;
import com.tactical.privacy.interfaces.DeleteStep;
import com.tactical.privacy.interfaces.DeleteStepRequest;
import com.tactical.privacy.interfaces.DeleteStepResponse;
import com.tactical.privacy.stats.Logger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DeleteOrchestrator {

    private static final Logger LOG = Logger.getLogger(DeleteOrchestrator.class);
    private final List<DeleteStep> deleteSteps;
    private final ObjectSerializer serializer;

    public DeleteOrchestrator(
        List<DeleteStep> orchestrationSteps,
        ObjectSerializer serializer)
    {
        this.deleteSteps = orchestrationSteps;
        this.serializer = serializer;
    }

    public DeleteOrchestratorResponse process(DeleteOrchestratorRequest request) {
        String processName = this.getClass().getSimpleName();
        LocalDateTime startedAt = LocalDateTime.now();
        List<DeleteStepResponse> deleteStepResponse = new ArrayList<>();

        try {
            LOG.info(processName + " started.");
            DeleteStepRequest stepRequest = map(request);


            for (DeleteStep step : deleteSteps)
            {
                DeleteStepResponse response = step.process(stepRequest);
                deleteStepResponse.add(response);
            }

            DeleteOrchestratorResponse response = DeleteOrchestratorResponse.builder()
                .companyId(request.getCompanyId())
                .startedAt(startedAt)
                .endedAt(LocalDateTime.now())
                .stepResults(deleteStepResponse.toArray(DeleteStepResponse[]::new))
                .build();

            LOG.info(processName + " ended.");
            LOG.info(serializer.toPrettyString(response));

            return response;
        } catch (Exception ex) {
            LOG.error(processName + "failed!", ex);
            throw ex;
        }
    }

    private DeleteStepRequest map(DeleteOrchestratorRequest request) {
        return DeleteStepRequest.builder()
            .companyId(request.getCompanyId())
            .identities(request.getUserIdentities())
            .build();
    }
}
