package com.tactical.privacy.orchestrator.interfaces;


public interface Orchestrator<I, O> {
    O process(I orchestratorRequest);
}
