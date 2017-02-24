package com.github.vanroy.springdata.specifications;

import java.util.Arrays;
import java.util.List;

import com.github.vanroy.springdata.specifications.model.Person;
import com.github.vanroy.springdata.specifications.output.ConsoleOutput;
import com.github.vanroy.springdata.specifications.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static antlr.build.ANTLR.root;
import static javafx.scene.input.KeyCode.T;
import static org.springframework.data.jpa.domain.Specifications.where;

@SpringBootApplication
public class Application implements CommandLineRunner {

    static List<Person> PERSONS = Arrays.asList(
            new Person("Homer", "Simpson", 42),
            new Person("Abraham", "Simpson", 78),
            new Person("Ned", "Flanders", 46),
            new Person("Barney", "Gumble", 39),
            new Person("Lisa", "Simpson", 8)
    );

    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private static Specification<Person> personIsAdult() {
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("age"), 18);
    }

    private static Specification<Person> personIsASimpson() {
        return (root, query, cb) -> cb.equal(root.get("lastName"), "Simpson");
    }

    @Override
    public void run(String... args) throws Exception {

        personRepository.save(PERSONS);

        ConsoleOutput.write(
            this.personRepository.findAll(
                where(personIsASimpson()).and(personIsAdult())
            )
        );
    }
}
