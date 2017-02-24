package com.github.vanroy.springdata.specifications.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Model represent a Person.
 * @author Julien Roy
 */
@Entity
public class Person {

    @Id
    private UUID id = UUID.randomUUID();

    private String firstName;
    private String lastName;
    private Integer age;

    public Person() {
    }

    public Person(String firstName, String lastName, Integer age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
