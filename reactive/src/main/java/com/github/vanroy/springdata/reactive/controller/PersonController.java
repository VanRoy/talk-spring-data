package com.github.vanroy.springdata.reactive.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.annotation.PostConstruct;

import com.github.vanroy.springdata.reactive.model.Person;
import com.github.vanroy.springdata.reactive.repository.PersonRepository;
import com.github.vanroy.springdata.reactive.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * Controller to expose new Person with SSE.
 *
 * @author Julien Roy
 */
@Controller
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository repository;
    private final NotificationService<Person> notificationService;

    PersonController(PersonRepository repository, NotificationService<Person> notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    @PostConstruct
    public void startStreaming() {
        repository.findBy().doOnNext(notificationService::sendMessage).subscribe();
    }

    @GetMapping
    public SseEmitter register() {
        return notificationService.registerClient();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Person p) {
        repository.save(p).block();
    }

}
