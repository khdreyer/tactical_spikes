package com.tactical.privacy.orchestrator;

import com.tactical.privacy.orchestrator.interfaces.Orchestrator;
import com.tactical.privacy.orchestrator.interfaces.OrchestratorRequest;
import com.tactical.privacy.orchestrator.interfaces.OrchestratorResponse;
import com.tactical.privacy.stats.Logger;

public class OrchestratorImpl implements Orchestrator<OrchestratorRequestImpl, OrchestratorResponseImpl> {
    private static Logger LOG = new Logger();

    @Override
    public OrchestratorResponseImpl process(OrchestratorRequestImpl orchestratorRequest) {
        LOG.info(String.format("Gonna orchestrate this %s", orchestratorRequest.toString()));
        return  OrchestratorResponseImpl.builder().build();
    }
}
