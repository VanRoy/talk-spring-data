package com.github.vanroy.springdata.rest.repository;

import com.github.vanroy.springdata.rest.model.Person;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Person repository.
 * @author Julien Roy
 */
@RepositoryRestResource
public interface PersonRepository extends CassandraRepository<Person> {

    @Query("SELECT * FROM person WHERE lastName = ?0 ALLOW FILTERING")
    Iterable<Person> findByLastName(@Param("lastName") String lastName);

    @Query("SELECT * FROM person WHERE lastName = ?0 AND firstName =?1 ALLOW FILTERING")
    Iterable<Person> findByLastNameAndFirstName(@Param("lastName") String lastName, @Param("firstName") String firstName);
}
