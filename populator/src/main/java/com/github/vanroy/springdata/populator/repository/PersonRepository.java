package com.github.vanroy.springdata.populator.repository;

import com.github.vanroy.springdata.populator.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

/**
 * Person repository.
 * @author Julien Roy
 */
public interface PersonRepository extends MongoRepository<Person, UUID> {
}
