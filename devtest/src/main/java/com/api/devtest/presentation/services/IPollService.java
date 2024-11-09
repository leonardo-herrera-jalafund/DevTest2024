package com.api.devtest.presentation.services;

import com.api.devtest.domain.models.Poll;

import java.util.Collection;
import java.util.Optional;

public interface IPollService {
    Optional<Poll> getPollById(Long id);
    Collection<Poll> getAllPolls();
    Poll createPoll(Poll poll);
}
