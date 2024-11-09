package com.api.devtest.presentation.services.concretes;

import com.api.devtest.domain.models.Poll;
import com.api.devtest.exceptions.ElementAlreadyExistException;
import com.api.devtest.exceptions.NoMinimalOptionsPollException;
import com.api.devtest.presentation.services.IPollService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class InMemoryPollService implements IPollService {
    public Map<Long, Poll> polls;

    public InMemoryPollService() {
        this.polls = new HashMap<>();
    }

    @Override
    public Optional<Poll> getPollById(Long id) {
        return Optional.ofNullable(polls.get(id));
    }

    @Override
    public Collection<Poll> getAllPolls() {
        return polls.values();
    }

    @Override
    public Poll createPoll(Poll poll) {
        if(polls.containsKey(poll.getId()))
            throw new ElementAlreadyExistException("Poll with id " + poll.getId() + " already exists");
        if(poll.getOptionsId().size() < 2)
            throw new NoMinimalOptionsPollException("Poll with id " + poll.getId() + " needs at least two options");
        return polls.put(poll.getId(), poll);
    }
}
