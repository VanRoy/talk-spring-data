package com.github.vanroy.springdata.audit.repository;

import java.util.UUID;

import com.github.vanroy.springdata.audit.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Person repository.
 * @author Julien Roy
 */
@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, UUID> {
}
