package com.tactical.privacy.reporting;

import org.immutables.value.Value;

@Value.Immutable
public interface DeleteReportStep {
    static Builder builder() {
        return ImmutableDeleteReportStep.builder();
    }

    String getName();

    String getStatus();

    long getDurationMs();

    @Value.Default
    default String[] getMessages() { return new String[]{}; };

    interface Builder {

        Builder name(String name);

        Builder status(String status);

        Builder durationMs(long durationMs);

        Builder messages(String[] messages);

        DeleteReportStep build();
    }
}