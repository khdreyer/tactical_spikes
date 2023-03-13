package com.tactical.privacy.controller;

import com.tactical.privacy.controller.dto.PrivacyDeleteRequestDto;
import com.tactical.privacy.interfaces.Orchestrator;
import com.tactical.privacy.interfaces.OrchestratorRequest;
import com.tactical.privacy.models.PrivacyDeleteStepType;
import com.tactical.privacy.repository.InMemoryPrivacyRequestRepository;
import com.tactical.privacy.stats.Logger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/privacy/")
public class PrivacyController {
    private static final Logger LOG = Logger.getLogger(PrivacyController.class);
    private final InMemoryPrivacyRequestRepository inMemoryPrivacyRequestRepository;
    private final Orchestrator orchestrator;

    @Autowired
    public PrivacyController(
        InMemoryPrivacyRequestRepository inMemoryPrivacyRequestRepository,
        Orchestrator orchestrator) {
        this.inMemoryPrivacyRequestRepository = inMemoryPrivacyRequestRepository;
        this.orchestrator = orchestrator;
    }

    @PostMapping(value = "add-request")
    public ResponseEntity addPrivacyRequest(@RequestBody PrivacyDeleteRequestDto requestDto) {
        LOG.info(String.format("Received privacy request: %s", requestDto.toString()));
        inMemoryPrivacyRequestRepository.pushRequest(requestDto);

        PrivacyDeleteStepType[] stepsToProcess = new PrivacyDeleteStepType[]{
            PrivacyDeleteStepType.SUBSCRIBER_EVENTS_DELETE
        };

        OrchestratorRequest orchestratorRequest = OrchestratorRequest.builder()
            .email(requestDto.getEmail())
            .phone(requestDto.getPhone())
            .companyId(requestDto.getCompanyId())
            .stepsToProcess(stepsToProcess)
            .build();

        orchestrator.process(orchestratorRequest);

        return new ResponseEntity(HttpStatus.OK);
    }
}
