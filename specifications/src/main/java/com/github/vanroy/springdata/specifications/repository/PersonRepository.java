package com.github.vanroy.springdata.specifications.repository;

import com.github.vanroy.springdata.specifications.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

/**
 * Person repository.
 * @author Julien Roy
 */
public interface PersonRepository extends JpaRepository<Person, UUID>, JpaSpecificationExecutor<Person> {

}
