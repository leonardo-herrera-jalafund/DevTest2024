package com.api.devtest.presentation.services.concretes;

import com.api.devtest.domain.models.Poll;
import com.api.devtest.infrastructure.repositories.IPollRepository;
import com.api.devtest.presentation.services.IPollService;
import org.springframework.stereotype.Service;

@Service
public class PollService implements IPollService {
    private final IPollRepository POLL_REPOSITORY;

    public PollService(IPollRepository pollRepository) {
        this.POLL_REPOSITORY = pollRepository;
    }

    @Override
    public void createPoll(Poll poll) {

    }
}
