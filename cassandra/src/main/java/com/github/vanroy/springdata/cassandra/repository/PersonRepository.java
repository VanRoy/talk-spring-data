package com.github.vanroy.springdata.cassandra.repository;

import com.github.vanroy.springdata.cassandra.model.Person;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

/**
 * Person repository.
 * @author Julien Roy
 */
public interface PersonRepository extends CassandraRepository<Person> {

    @Query("SELECT firstName, age FROM person WHERE lastName = ?0")
    Iterable<Person> findByLastName(String lastName);

    Iterable<Person> findByLastNameAndFirstName(String lastName, String firstName);
}
