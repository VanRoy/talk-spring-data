package com.github.vanroy.springdata.rest.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

/**
 * Model represent a Person.
 * @author Julien Roy
 */
@Table
@Data
@NoArgsConstructor
public class Person {

    @Id
    private String id;

    private String lastName;

    private String firstName;

    private Integer age;

    public Person(String firstName, String lastName, Integer age) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
