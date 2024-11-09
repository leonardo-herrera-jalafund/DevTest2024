package com.api.devtest.presentation.services.concretes;

import com.api.devtest.domain.models.Option;
import com.api.devtest.domain.models.Poll;
//import com.api.devtest.infrastructure.repositories.IPollRepository;
import com.api.devtest.domain.models.Vote;
import com.api.devtest.presentation.services.IPollService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class DatabasePollService implements IPollService {
    //private final IPollRepository POLL_REPOSITORY;

//    public DatabasePollService(IPollRepository pollRepository) {
//        //this.POLL_REPOSITORY = pollRepository;
//    }

    @Override
    public Optional<Poll> getPollById(Long id) {
        //return POLL_REPOSITORY.findById(id);
        return Optional.empty();
    }

    @Override
    public Collection<Poll> getAllPolls() {
        //return POLL_REPOSITORY.findAll();
        return null;
    }

    @Override
    public Poll createPoll(Poll poll) {
        //POLL_REPOSITORY.save(poll);
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
