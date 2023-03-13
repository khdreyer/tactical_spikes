package com.tactical.privacy;

import com.tactical.privacy.helpers.ObjectSerializer;
import com.tactical.privacy.interfaces.Orchestrator;
import com.tactical.privacy.interfaces.OrchestratorRequest;
import com.tactical.privacy.interfaces.OrchestratorResponse;
import com.tactical.privacy.interfaces.Step;
import com.tactical.privacy.interfaces.StepRequest;
import com.tactical.privacy.interfaces.StepResponse;
import com.tactical.privacy.stats.Logger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PrivacyDeleteOrchestrator implements Orchestrator {

    private static final Logger LOG = Logger.getLogger(PrivacyDeleteOrchestrator.class);
    private final List<Step> orchestrationSteps;
    private final ObjectSerializer serializer;

    public PrivacyDeleteOrchestrator(
        List<Step> orchestrationSteps,
        ObjectSerializer serializer)
    {
        this.orchestrationSteps = orchestrationSteps;
        this.serializer = serializer;
    }

    @Override
    public OrchestratorResponse process(OrchestratorRequest request) {
        var processName = this.getClass().getSimpleName();
        var startedAt = LocalDateTime.now();
        List<StepResponse> stepResponses = new ArrayList<>();

        try {
            LOG.info(processName + " started.");
            StepRequest stepRequest = map(request);


            for (Step step : orchestrationSteps)
            {
                var response = step.process(stepRequest);
                stepResponses.add(response);
            }

            var response = OrchestratorResponse.builder()
                .startedAt(startedAt)
                .endedAt(LocalDateTime.now())
                .stepResults(stepResponses.toArray(StepResponse[]::new))
                .build();

            LOG.info(processName + " ended.");
            LOG.info(serializer.toPrettyString(response));

            return response;
        } catch (Exception ex) {
            LOG.error(processName + "failed!", ex);
            throw ex;
        }
    }

    private StepRequest map(OrchestratorRequest request) {
        return StepRequest.builder()
            .companyId(request.getCompanyId())
            .identities(request.getUserIdentities())
            .build();
    }
}
