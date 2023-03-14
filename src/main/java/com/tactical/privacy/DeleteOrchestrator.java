package com.tactical.privacy;

import com.tactical.privacy.helpers.ObjectSerializer;
import com.tactical.privacy.interfaces.DeleteOrchestratorRequest;
import com.tactical.privacy.interfaces.DeleteOrchestratorResponse;
import com.tactical.privacy.interfaces.DeleteStep;
import com.tactical.privacy.interfaces.DeleteStepRequest;
import com.tactical.privacy.interfaces.DeleteStepResponse;
import com.tactical.privacy.models.DeleteStepType;
import com.tactical.privacy.stats.Logger;
import com.tactical.privacy.steps.DeleteStepValidator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DeleteOrchestrator {

    private static final Logger LOG = Logger.getLogger(DeleteOrchestrator.class);
    private final List<DeleteStep> deleteSteps;
    private final DeleteStepValidator stepValidator;
    private final ObjectSerializer serializer;

    public DeleteOrchestrator(
        List<DeleteStep> orchestrationSteps,
        DeleteStepValidator stepValidator,
        ObjectSerializer serializer)
    {
        this.deleteSteps = orchestrationSteps;
        this.stepValidator = stepValidator;
        this.serializer = serializer;
    }

    public DeleteOrchestratorResponse process(DeleteOrchestratorRequest request) throws Exception {
        String processName = this.getClass().getSimpleName();
        LocalDateTime startedAt = LocalDateTime.now();
        List<DeleteStepResponse> deleteStepResponse = new ArrayList<>();

        try {
            LOG.info(processName + " started.");
            DeleteStepRequest stepRequest = map(request);

            stepValidator.throwIfInvalid(deleteSteps);

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

    private void validateSteps(List<DeleteStep> steps) throws Exception {
        try {
            // ensure that the list of step types are unique.
            Set<DeleteStepType> set = steps.stream().map(DeleteStep::getType).collect(Collectors.toSet());
            if (set.size() == steps.size()) {
                LOG.info(set.size() +  " unique steps found to process.");
            } else {
                throw new Exception("Orchestration steps provided were not unique.");
            }
        } catch (Exception ex) {
            LOG.error("Delete steps are not unique. More than one type exists in the collection.", ex);
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
