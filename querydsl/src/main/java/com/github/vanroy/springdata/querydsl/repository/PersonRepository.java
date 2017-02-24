package com.github.vanroy.springdata.querydsl.repository;

import java.util.UUID;

import com.github.vanroy.springdata.querydsl.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Person repository.
 * @author Julien Roy
 */
public interface PersonRepository extends JpaRepository<Person, UUID>, QueryDslPredicateExecutor<Person> {

}
