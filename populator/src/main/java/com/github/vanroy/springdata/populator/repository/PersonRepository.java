package com.github.vanroy.springdata.populator.repository;

import java.util.UUID;

import com.github.vanroy.springdata.populator.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Person repository.
 * @author Julien Roy
 */
public interface PersonRepository extends MongoRepository<Person, UUID> {
}
