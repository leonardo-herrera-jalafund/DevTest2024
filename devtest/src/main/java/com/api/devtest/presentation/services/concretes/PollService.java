package com.api.devtest.presentation.services.concretes;

import com.api.devtest.domain.models.Option;
import com.api.devtest.domain.models.Poll;
import com.api.devtest.domain.models.Vote;
import com.api.devtest.presentation.services.IPollService;

import java.util.Collection;
import java.util.Optional;

public class PollService implements IPollService {
    @Override
    public Optional<Poll> getPollById(Long id) {
        return null;
    }

    @Override
    public Collection<Poll> getAllPolls() {
        return null;
    }

    @Override
    public Poll createPoll(Poll poll) {
return null;
    }

    @Override
    public Vote createVote(Vote vote) {
        return null;
    }

    @Override
    public Option createOption(Option option) {
        return null;
    }
}
