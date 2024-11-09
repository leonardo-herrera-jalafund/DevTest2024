package com.api.devtest.application.controllers.concretes;

import com.api.devtest.application.controllers.IPollController;
import com.api.devtest.domain.models.Poll;
import com.api.devtest.exceptions.poll.ElementAlreadyExistException;
import com.api.devtest.exceptions.options.NoMinimalOptionsPollException;
import com.api.devtest.presentation.services.concretes.InMemoryPollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/polls")
public class PollController implements IPollController {
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
    @Override
    public ResponseEntity<String> createPoll(Poll poll) {
        try {
            POLL_SERVICE.createPoll(poll);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ElementAlreadyExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (NoMinimalOptionsPollException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
