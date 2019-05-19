package com.github.vanroy.springdata.reactive.repository;

import com.github.vanroy.springdata.reactive.model.Person;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

/**
 * Person repository.
 * @author Julien Roy
 */
public interface PersonRepository extends ReactiveCrudRepository<Person, UUID> {

    @Tailable
    Flux<Person> findBy();

    Flux<Person> findByAgeGreaterThan(int age);

    Flux<Person> findByFirstName(String lastName);
}
