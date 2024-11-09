package com.api.devtest.application.controllers.concretes;

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
import com.api.devtest.presentation.services.concretes.InMemoryPollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/polls")
public class PollController {
    private final InMemoryPollService POLL_SERVICE;

    public PollController(InMemoryPollService pollService) {
        this.POLL_SERVICE = pollService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPollById(@PathVariable Long id) {
        Optional<Poll> poll = POLL_SERVICE.getPollById(id);
        return poll.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Collection<Poll>> getAllPolls() {
        Collection<Poll> polls = POLL_SERVICE.getAllPolls();
        return new ResponseEntity<>(polls, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<String> createPoll(@RequestBody Poll poll) {
        try {
            POLL_SERVICE.createPoll(poll);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ElementAlreadyExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (NoMinimalOptionsPollException
                 | NoCorrectFormatForIdException
                 | EmptyPollNameException
                  e ){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/{id}/votes")
    public ResponseEntity<String> createVote(@PathVariable Long id, @RequestBody Vote vote) {
        try {
            POLL_SERVICE.createVote(vote);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (NoPollFound | NoOptionFound e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/option")
    public ResponseEntity<String> createOption(@RequestBody Option option) {
        try {
            POLL_SERVICE.createOption(option);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (OptionAlreadyExistException | EmptyPollOptionNameException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}/options")
    public ResponseEntity<Collection<Option>> getPollOptions(@PathVariable Long id) {
        POLL_SERVICE.getPollOptions(id);
        return new ResponseEntity<>(POLL_SERVICE.getPollOptions(id), HttpStatus.ACCEPTED);
    }

}
