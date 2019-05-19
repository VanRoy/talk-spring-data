package com.github.vanroy.springdata.querydsl.repository;

import com.github.vanroy.springdata.querydsl.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

/**
 * Person repository.
 * @author Julien Roy
 */
public interface PersonRepository extends JpaRepository<Person, UUID>, QuerydslPredicateExecutor<Person> {

}
