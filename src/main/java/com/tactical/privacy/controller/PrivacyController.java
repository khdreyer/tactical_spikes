package com.tactical.privacy.controller;

import com.tactical.privacy.DeleteOrchestrator;
import com.tactical.privacy.DeleteRequestTransformer;
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
    private final DeleteRequestTransformer requestTransformer;
    private final PrivacyRepository privacyRepository;

    @Autowired
    public PrivacyController(
        DeleteRequestTransformer requestTransformer,
        DeleteOrchestrator deleteOrchestrator,
        PrivacyRepository privacyRepository)
    {
        this.requestTransformer = requestTransformer;
        this.deleteOrchestrator = deleteOrchestrator;
        this.privacyRepository = privacyRepository;
    }

    @GetMapping("/")
    public String test(){
        return "Working!";
    }

    @PostMapping(value = "/add-request")
    public ResponseEntity addPrivacyRequest(@RequestBody PrivacyDeleteRequestDto requestDto) {
        LOG.info(String.format("Received privacy delete add request: %s", requestDto.toString()));
        privacyRepository.writeDeleteRequest(requestDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/process-request")
    public ResponseEntity processPrivacyRequest(@RequestBody PrivacyDeleteRequestDto requestDto) {
        HttpStatus status = HttpStatus.OK;
        LOG.info(String.format("Received privacy delete process request: %s", requestDto.toString()));
//        DeleteStepType[] stepsToProcess = new DeleteStepType[]{
//            DeleteStepType.SUBSCRIBER_EVENTS_DELETE
//        };

        try {
            DeleteOrchestratorRequest orchestratorRequest = requestTransformer.transform(requestDto);
            deleteOrchestrator.process(orchestratorRequest);
        } catch (Exception ex) {
            LOG.error("An error occurred while processing a privacy delete request.", ex);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity(status);
    }
}