package com.github.vanroy.springdata.cassandra.repository;

import com.github.vanroy.springdata.cassandra.model.Person;
import org.springframework.data.cassandra.repository.CassandraRepository;

/**
 * Person repository.
 * @author Julien Roy
 */
public interface PersonRepository extends CassandraRepository<Person> {

    Iterable<Person> findByLastName(String lastName);

    Iterable<Person> findByLastNameAndFirstName(String lastName, String firstName);
}

