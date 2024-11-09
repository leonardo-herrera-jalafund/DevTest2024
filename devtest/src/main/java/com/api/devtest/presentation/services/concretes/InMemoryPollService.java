package com.api.devtest.presentation.services.concretes;

import com.api.devtest.domain.models.Option;
import com.api.devtest.domain.models.Poll;
import com.api.devtest.domain.models.Vote;
import com.api.devtest.exceptions.options.EmptyPollOptionNameException;
import com.api.devtest.exceptions.options.NoOptionFound;
import com.api.devtest.exceptions.options.OptionAlreadyExistException;
import com.api.devtest.exceptions.poll.ElementAlreadyExistException;
import com.api.devtest.exceptions.options.NoMinimalOptionsPollException;
import com.api.devtest.exceptions.poll.EmptyPollNameException;
import com.api.devtest.exceptions.poll.NoCorrectFormatForIdException;
import com.api.devtest.exceptions.poll.NoPollFound;
import com.api.devtest.presentation.services.IPollService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InMemoryPollService implements IPollService {
    public Map<Long, Poll> polls;
    public Map<Long, Option> options;
    public Map<Long, Vote> votes;

    public InMemoryPollService() {
        this.polls = new HashMap<>();
        this.options = new HashMap<>();
        this.votes = new HashMap<>();
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
        if (poll.getId() < 1)
            throw new NoCorrectFormatForIdException("No correct format for id " + poll.getId());
        if(poll.getName() == null || poll.getName().isEmpty())
            throw new EmptyPollNameException("Empty poll name");
        if(poll.getOptionsId().size() < 2)
            throw new NoMinimalOptionsPollException("Poll with id " + poll.getId() + " needs at least two options");
        for(Long optionId : poll.getOptionsId()) {
            if(!options.containsKey(optionId)) {
                throw new NoOptionFound("Option with id " + optionId + " does not exist");
            }
        }

        return polls.put(poll.getId(), poll);
    }

    @Override
    public Vote createVote(Vote vote) {
        if(!polls.containsKey(vote.getPollId()))
            throw new NoPollFound("Poll with id " + vote.getPollId() + " not found");
        if(!options.containsKey(vote.getOptionId()))
            throw new NoOptionFound("Option with id " + vote.getOptionId() + " not found");

        Option currentOption = options.get(vote.getOptionId());
        currentOption.setVotes(currentOption.getVotes() + 1);
        return  votes.put(vote.getId(), vote);
    }

    @Override
    public Option createOption(Option option) {
        if(options.containsKey(option.getId()))
            throw new OptionAlreadyExistException("Option with id " + option.getId() + " already exists");
        if(option.getName().isEmpty())
            throw new EmptyPollOptionNameException("Empty poll option name");

        return options.put(option.getId(), option);
    }

    public Collection<Option> getPollOptions(Long pollId) {
        Optional<Poll> poll = getPollById(pollId);
        Collection<Option> pollOptions = new ArrayList<>();
        for(Long option : poll.get().getOptionsId()) {
            Option pollOption = options.get(option);
            pollOptions.add(pollOption);
        }
        return pollOptions;
    }
}
