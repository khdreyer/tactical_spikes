package com.tactical.privacy.reporting;

import com.tactical.privacy.interfaces.DeleteOrchestratorResponse;
import com.tactical.privacy.interfaces.DeleteStepResponse;
import com.tactical.privacy.stats.Logger;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DeleteReportBuilder {

    private static final Logger LOG = Logger.getLogger(DeleteReport.class);

    public DeleteReport map(int requestId, DeleteOrchestratorResponse response) {
        try {
            String start = formatDateTime(response.getStartedAt());
            String end = formatDateTime(response.getEndedAt());
            long durationMS = Duration.between(response.getStartedAt(), response.getEndedAt()).toMillis();
            DeleteReportStep[] steps = map(response.getStepResults());

            return DeleteReport.builder()
                .requestId(requestId)
                .startDateTime(start)
                .endDateTime(end)
                .durationMs(durationMS)
                .stepReports(steps)
                .build();
        } catch (Exception ex){
            LOG.error("Failed to map orchestrator response to report object.", ex);
            throw ex;
        }
    }

    private String formatDateTime(LocalDateTime dt) {
        String DATE_TIME_FORMAT = "MM-dd-yyyy hh:mm:ss";
        var dtf = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        return dtf.format(dt);
    }

    private DeleteReportStep[] map(DeleteStepResponse[] stepResponses) {
        var reportSteps = new ArrayList<DeleteReportStep>();

        for (DeleteStepResponse stepResponse : stepResponses) {

            long durationMs = Duration.between(stepResponse.getStartedAt(), stepResponse.getEndedAt()).toMillis();
            var stepReport = DeleteReportStep.builder()
                .name(stepResponse.getStepType().toString())
                .status(stepResponse.getStepStatus().toString())
                .durationMs(durationMs)
                .build();
            reportSteps.add(stepReport);
        }

        return reportSteps.toArray(DeleteReportStep[]::new);
    }
}
