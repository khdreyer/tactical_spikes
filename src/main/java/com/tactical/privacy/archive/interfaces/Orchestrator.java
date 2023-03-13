package com.tactical.privacy.archive.interfaces;


public interface Orchestrator<I, O> {
    O process(I orchestratorRequest);
}
