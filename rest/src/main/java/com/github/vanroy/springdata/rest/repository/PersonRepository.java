package com.github.vanroy.springdata.rest.repository;

import java.util.UUID;

import com.github.vanroy.springdata.rest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Person repository.
 * @author Julien Roy
 */
@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, UUID> {

    Iterable<Person> findAllByOrderByAgeAsc();

    Person findByFirstName(@Param("firstName") String firstName);

    Iterable<Person> findByLastNameIgnoreCaseAndAgeGreaterThan(@Param("lastName") String lastName, @Param("age") int age);
}
