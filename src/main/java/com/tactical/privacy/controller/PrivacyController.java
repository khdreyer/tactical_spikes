package com.tactical.privacy.controller;

import com.tactical.privacy.dto.PrivacyRequestDto;
import com.tactical.privacy.repository.InMemoryPrivacyRequestRepository;
import com.tactical.privacy.stats.Logger;
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
    private final InMemoryPrivacyRequestRepository inMemoryPrivacyRequestRepository;

    @Autowired
    public PrivacyController(InMemoryPrivacyRequestRepository inMemoryPrivacyRequestRepository, InMemoryPrivacyRequestRepository inMemoryPrivacyRequestRepository1) {
        this.inMemoryPrivacyRequestRepository = inMemoryPrivacyRequestRepository1;
    }

    private static final Logger LOG = new Logger();
    @PostMapping(value = "add-request")
    public ResponseEntity addPrivacyRequest(@RequestBody PrivacyRequestDto privacyRequestDto) {
        LOG.info(String.format("Recieved privacy request: %s", privacyRequestDto.toString()));
        inMemoryPrivacyRequestRepository.pushRequest(privacyRequestDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
