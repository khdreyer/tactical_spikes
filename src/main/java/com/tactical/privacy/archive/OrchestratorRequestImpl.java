//package com.tactical.privacy.orchestrator;
//
//import com.tactical.privacy.orchestrator.interfaces.OrchestratorRequest;
//import java.util.List;
//import org.immutables.value.Value;
//
//@Value.Immutable
//public interface OrchestratorRequest {
//    static Builder builder() {
//        return ImmutableOrchestratorRequest.builder();
//    }
//
//    String getPhone();
//    String getEmail();
//
//    List<OrchestratorStepType> getStepsToProcess();
//    Long getCompanyId();
//
//
//    interface Builder {
//        Builder phone(String phone);
//
//        Builder email(String email);
//
//        Builder stepsToProcess(Iterable<? extends OrchestratorStepType> stepsToProcess);
//
//        Builder companyId(Long companyId);
//
//        OrchestratorRequestImpl build();
//    }
//}
