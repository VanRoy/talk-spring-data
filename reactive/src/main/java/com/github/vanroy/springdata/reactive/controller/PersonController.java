package com.github.vanroy.springdata.reactive.controller;

import com.github.vanroy.springdata.reactive.model.Person;
import com.github.vanroy.springdata.reactive.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controller to expose new Person with SSE.
 *
 * @author Julien Roy
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository repository;

    PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Person> create(@RequestBody Person person) {
        return repository.save(person);
    }

    @GetMapping
    public Flux<Person> search() {
        return
                Flux.merge(
                        repository.findByAgeGreaterThan(30),
                        repository.findByFirstName("Brian")
                ).distinct();
    }

    @GetMapping(path = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> streamFlux() {
        return repository.findBy();
    }

}
