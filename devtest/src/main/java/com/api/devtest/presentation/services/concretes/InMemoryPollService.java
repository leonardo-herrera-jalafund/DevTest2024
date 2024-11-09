package com.api.devtest.presentation.services.concretes;

import com.api.devtest.domain.models.Poll;
import com.api.devtest.presentation.services.IPollService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class InMemoryPollService implements IPollService {
    public Map<UUID, Poll> polls;

    @Override
    public void createPoll(Poll poll) {
        polls.put(poll.getId(), poll);
    }
}
