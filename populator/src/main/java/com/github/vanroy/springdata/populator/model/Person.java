package com.github.vanroy.springdata.populator.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Model represent a Person.
 * @author Julien Roy
 */
@Document
@Data
@NoArgsConstructor
public class Person {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Integer age;

    public Person(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
