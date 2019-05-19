package com.github.vanroy.springdata.basics.repository;

import com.github.vanroy.springdata.basics.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

/**
 * Person repository.
 * @author Julien Roy
 */
public interface PersonRepository extends JpaRepository<Person, UUID> {

    Iterable<Person> findAllByOrderByAgeAsc();

    Person findByFirstName(String firstName);

    @Query(value = "SELECT * FROM person WHERE lower(last_name) = lower(?)", nativeQuery = true)
    Iterable<Person> findByLastName(String lastName);

    Iterable<Person> findByLastNameIgnoreCaseAndAgeGreaterThan(String firstName, int age);
}
