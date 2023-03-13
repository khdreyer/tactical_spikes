package com.tactical.privacy.controller;

import com.tactical.privacy.DeleteOrchestrator;
import com.tactical.privacy.DeleteRequestEnricher;
import com.tactical.privacy.controller.dto.PrivacyDeleteRequestDto;
import com.tactical.privacy.interfaces.DeleteOrchestratorRequest;
import com.tactical.privacy.repos.PrivacyRepository;
import com.tactical.privacy.stats.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/privacy")
public class PrivacyController {
    private static final Logger LOG = Logger.getLogger(PrivacyController.class);
    private final DeleteOrchestrator deleteOrchestrator;
    private final DeleteRequestEnricher requestEnricher;
    private final PrivacyRepository privacyRepository;

    @Autowired
    public PrivacyController(
        DeleteRequestEnricher requestEnricher,
        DeleteOrchestrator deleteOrchestrator,
        PrivacyRepository privacyRepository)
    {
        this.requestEnricher = requestEnricher;
        this.deleteOrchestrator = deleteOrchestrator;
        this.privacyRepository = privacyRepository;
    }

    @GetMapping("/")
    public String test(){
        return "Working!";
    }

    @PostMapping(value = "/add-request")
    public ResponseEntity addPrivacyRequest(@RequestBody PrivacyDeleteRequestDto requestDto) {
        LOG.info(String.format("Received privacy request: %s", requestDto.toString()));
        privacyRepository.writeDeleteRequest(requestDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/process-request")
    public ResponseEntity processPrivacyRequest(@RequestBody PrivacyDeleteRequestDto requestDto) {

//        DeleteStepType[] stepsToProcess = new DeleteStepType[]{
//            DeleteStepType.SUBSCRIBER_EVENTS_DELETE
//        };

        DeleteOrchestratorRequest orchestratorRequest = requestEnricher.transform(requestDto);
        deleteOrchestrator.process(orchestratorRequest);
        return new ResponseEntity(HttpStatus.OK);
    }
}