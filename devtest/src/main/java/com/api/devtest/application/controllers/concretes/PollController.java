package com.api.devtest.application.controllers.concretes;

import com.api.devtest.application.controllers.IPollController;
import com.api.devtest.domain.models.Poll;
import com.api.devtest.presentation.services.IPollService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/polls")
public class PollController implements IPollController {
    private final IPollService POLL_SERVICE;

    public PollController(IPollService pollService) {
        this.POLL_SERVICE = pollService;
    }

    @PostMapping
    @Override
    public void createPoll(Poll poll) {
        POLL_SERVICE.createPoll(poll);
    }
}
