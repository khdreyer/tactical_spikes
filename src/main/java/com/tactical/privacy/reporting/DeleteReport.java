package com.tactical.privacy.reporting;

import org.immutables.value.Value;

@Value.Immutable
public interface DeleteReport {
    static Builder builder() {
        return ImmutableDeleteReport.builder();
    }

    int getRequestId();

    String getStartDateTime();

    String getEndDateTime();

    long getDurationMs();

    DeleteReportStep[] getStepReports();

    interface Builder {

        Builder requestId(int requestId);

        Builder startDateTime(String startDateTime);

        Builder endDateTime(String endDateTime);

        Builder durationMs(long durationMs);

        Builder stepReports(DeleteReportStep[] stepReports);

        DeleteReport build();
    }
}