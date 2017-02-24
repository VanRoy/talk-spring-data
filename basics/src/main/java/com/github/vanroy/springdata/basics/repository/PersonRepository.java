package com.github.vanroy.springdata.basics.repository;

import java.util.UUID;

import com.github.vanroy.springdata.basics.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Person repository.
 * @author Julien Roy
 */
public interface PersonRepository extends JpaRepository<Person, UUID> {

    Iterable<Person> findAllByOrderByAgeAsc();

    Person findByFirstName(String firstName);

    Iterable<Person> findByLastNameIgnoreCaseAndAgeGreaterThan(String firstName, int age);
}
