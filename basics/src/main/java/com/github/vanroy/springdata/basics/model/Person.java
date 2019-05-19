package com.github.vanroy.springdata.basics.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Model represent a Person.
 * @author Julien Roy
 */
@Entity
@Data
@NoArgsConstructor
public class Person {

    @Id
    private UUID id = UUID.randomUUID();

    private String firstName;
    private String lastName;
    private Integer age;

    public Person(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
