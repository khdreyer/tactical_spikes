package com.tactical.privacy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.GsonBuilder;
import com.tactical.privacy.interfaces.Identities;
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

    public PrivacyDeleteOrchestrator(List<Step> orchestrationSteps){
        this.orchestrationSteps = orchestrationSteps;
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

            printResult(response);

            return response;
        } catch (Exception ex) {
            LOG.error(processName + "failed!", ex);
            throw ex;
        }
    }

    private void printResult(OrchestratorResponse result) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            var prettyJson = mapper.writeValueAsString(result);
            LOG.info(prettyJson);
        } catch (Exception ex){
            LOG.error("Error printing result.", ex);
        }
//        var gson = new GsonBuilder().setPrettyPrinting().create(); // pretty print
//        String prettyJson = gson.toJson(result);
//        LOG.info(prettyJson);
    }

    private StepRequest map(OrchestratorRequest request) {

        var identities = getIdentities(request);

        return StepRequest.builder()
            .companyId(request.getCompanyId())
            .identities(identities)
            .build();
    }

    private Identities getIdentities(OrchestratorRequest request) {
        return Identities.builder()
            .email(request.getEmail())
            .phone(request.getPhone())
            .subscriberId(1111L)
            .visitorId("VISITORID123")
            .build();
    }
}
