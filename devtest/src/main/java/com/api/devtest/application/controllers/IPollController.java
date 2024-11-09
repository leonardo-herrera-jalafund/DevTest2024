package com.api.devtest.application.controllers;

import com.api.devtest.domain.models.Poll;
import org.springframework.http.ResponseEntity;

public interface IPollController {
    ResponseEntity<String> createPoll(Poll poll);
}
