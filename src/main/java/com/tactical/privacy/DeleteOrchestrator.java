package com.tactical.privacy;

import com.tactical.privacy.helpers.ObjectSerializer;
import com.tactical.privacy.interfaces.DeleteOrchestratorRequest;
import com.tactical.privacy.interfaces.DeleteOrchestratorResponse;
import com.tactical.privacy.interfaces.DeleteStep;
import com.tactical.privacy.interfaces.DeleteStepRequest;
import com.tactical.privacy.interfaces.DeleteStepResponse;
import com.tactical.privacy.models.DeleteStepType;
import com.tactical.privacy.stats.Logger;
import com.tactical.privacy.steps.utils.DeleteStepValidator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DeleteOrchestrator {

    private static final Logger LOG = Logger.getLogger(DeleteOrchestrator.class);
    private final DeleteStep[] deleteSteps;
    private final DeleteStepValidator stepValidator;
    private final ObjectSerializer serializer;

    public DeleteOrchestrator(
        DeleteStep[] orchestrationSteps,
        DeleteStepValidator stepValidator,
        ObjectSerializer serializer)
    {
        this.deleteSteps = orchestrationSteps;
        this.stepValidator = stepValidator;
        this.serializer = serializer;
    }

    public DeleteOrchestratorResponse process(DeleteOrchestratorRequest request) {
        String processName = this.getClass().getSimpleName();
        LocalDateTime startedAt = LocalDateTime.now();
        List<DeleteStepResponse> deleteStepResponse = new ArrayList<>();

        try {
            LOG.info(processName + " started.");
            DeleteStepRequest stepRequest = map(request);

            var filter = request.getStepFilter();
            stepValidator.throwIfInvalid(deleteSteps, filter);

            for (DeleteStep step : deleteSteps)
            {
                DeleteStepResponse response;
                if (shouldRunStep(filter, step.getType())){
                    response = step.process(stepRequest);
                } else {
                    response = step.skip(stepRequest);
                }
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
            LOG.info(serializer.toPrettyString(request));
            LOG.error(processName + "failed!", ex);
            throw ex;
        }
    }

    private boolean shouldRunStep(DeleteStepType[] filter, DeleteStepType typeToRun) {
        if (filter.length < 1) { // filter not set. Run all
            return true;
        }

        var found = false;
        for (DeleteStepType stepType : filter) {
            if (typeToRun == stepType) {
                found = true;
                break;
            }
        }
        return found;
    }

    private DeleteStepRequest map(DeleteOrchestratorRequest request) {
        return DeleteStepRequest.builder()
            .companyId(request.getCompanyId())
            .identities(request.getUserIdentities())
            .build();
    }
}