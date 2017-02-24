package com.github.vanroy.springdata.audit.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Model represent a Person.
 * @author Julien Roy
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class Person {

    @Id
    private UUID id = UUID.randomUUID();

    @CreatedDate
    private String createdDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private String lastModifiedDate;

    @LastModifiedBy
    private String lastModifiedBy;

    private String firstName;
    private String lastName;
    private Integer age;

    public Person(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
