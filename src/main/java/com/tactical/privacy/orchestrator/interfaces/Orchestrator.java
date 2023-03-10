package com.tactical.privacy.orchestrator.interfaces;


public interface Orchestrator<I, O> {
    OrchestratorResponse<O> process(OrchestratorRequest<I> orchestratorRequest);

}
