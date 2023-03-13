//package com.tactical.privacy.orchestrator;
//
//import com.tactical.privacy.orchestrator.interfaces.OrchestratorResponse;
//import com.tactical.privacy.orchestrator.interfaces.StepResponse;
//import java.util.List;
//import org.immutables.value.Value;
//
//@Value.Immutable
//public interface OrchestratorResponseImpl extends OrchestratorResponse<String> {
//    static Builder builder() {
//        return ImmutableOrchestratorResponseImpl.builder();
//    }
//
//    List<StepResponse> collectStepResponses();
//
//
//    interface Builder {
//        Builder collectStepResponses(Iterable<? extends StepResponse> collectStepResponses);
//
//        OrchestratorResponseImpl build();
//    }
//}
