package com.github.vanroy.springdata.reactive.controller;

import java.util.List;
import javax.annotation.PostConstruct;

import com.github.vanroy.springdata.reactive.model.Person;
import com.github.vanroy.springdata.reactive.repository.PersonRepository;
import com.github.vanroy.springdata.reactive.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;

/**
 * Controller to expose new Person with SSE.
 *
 * @author Julien Roy
 */
@RestController
@RequestMapping("/sse")
public class SseController {

    private final NotificationService<Person> notificationService;

    SseController(NotificationService<Person> notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public SseEmitter register() {
        return notificationService.registerClient();
    }

}
