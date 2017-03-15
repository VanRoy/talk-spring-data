package com.github.vanroy.springdata.reactive.repository;

import java.util.UUID;

import com.github.vanroy.springdata.reactive.model.Person;
import org.reactivestreams.Publisher;
import org.springframework.data.mongodb.repository.InfiniteStream;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * Person repository.
 * @author Julien Roy
 */
public interface PersonRepository extends ReactiveCrudRepository<Person, UUID> {

    @InfiniteStream// Use a tailable cursor
    Flux<Person> findBy();

    Flux<Person> findByAgeGreaterThan(int age);

    Flux<Person> findByFirstName(String lastName);
}
