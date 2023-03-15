package com.attentivemobile.privacy.controller;

import com.attentivemobile.privacy.controller.dto.PrivacyDeleteRequestDto;
import com.attentivemobile.privacy.services.DeleteRunner;
import com.attentivemobile.privacy.stats.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v2/privacy")
public class PrivacyController {
    private static final Logger LOG = Logger.getLogger(PrivacyController.class);
    private final DeleteRunner deleteRunner;

    @Autowired
    public PrivacyController(
        DeleteRunner deleteRunner
    )
    {
        this.deleteRunner = deleteRunner;
    }

    @GetMapping("/")
    public String test(){
        return "Working!";
    }

    @PostMapping(value = "/add-request")
    public ResponseEntity addPrivacyRequest(@RequestBody PrivacyDeleteRequestDto requestDto) {
        LOG.info(String.format("Received privacy delete add request: %s", requestDto.toString()));
        //privacyRepository.writeDeleteRequest(requestDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/process-request")
    public ResponseEntity processPrivacyRequest(@RequestBody PrivacyDeleteRequestDto requestDto) {
        HttpStatus status = HttpStatus.OK;
        LOG.info(String.format("Received privacy delete process request: %s", requestDto.toString()));
        try {
            deleteRunner.run(requestDto);
        } catch (Exception ex) {
            LOG.error("An error occurred while processing a privacy delete request.", ex);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity(status);
    }
}