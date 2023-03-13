package com.tactical.privacy.controller;

import com.tactical.privacy.interfaces.Orchestrator;
import com.tactical.privacy.repository.InMemoryPrivacyRequestRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/privacy/")
public class PrivacyController {
    private final InMemoryPrivacyRequestRepository inMemoryPrivacyRequestRepository;
    private final Orchestrator orchestrator;

    public PrivacyController(InMemoryPrivacyRequestRepository inMemoryPrivacyRequestRepository,
                             Orchestrator orchestrator) {
        this.inMemoryPrivacyRequestRepository = inMemoryPrivacyRequestRepository;
        this.orchestrator = orchestrator;
    }

//    @Autowired
//    public PrivacyController(InMemoryPrivacyRequestRepository inMemoryPrivacyRequestRepository, InMemoryPrivacyRequestRepository inMemoryPrivacyRequestRepository1, OrchestratorImpl orchestrator) {
//        this.inMemoryPrivacyRequestRepository = inMemoryPrivacyRequestRepository1;
//        this.orchestrator = orchestrator;
//    }
//
//    private static final Logger LOG = new Logger();
//    @PostMapping(value = "add-request")
//    public ResponseEntity addPrivacyRequest(@RequestBody PrivacyRequestDto privacyRequestDto) {
//        LOG.info(String.format("Recieved privacy request: %s", privacyRequestDto.toString()));
//        inMemoryPrivacyRequestRepository.pushRequest(privacyRequestDto);
//        OrchestratorRequestImpl orchestratorRequest = OrchestratorRequestImpl.builder()
//            .email(privacyRequestDto.email())
//            .phone(privacyRequestDto.phone())
//            .companyId(privacyRequestDto.companyId())
//            .stepsToProcess(List.of(OrchestratorStepType.Subscriber))
//            .build();
//
//        orchestrator.process(orchestratorRequest);
//
//        return new ResponseEntity(HttpStatus.OK);
//    }
}
