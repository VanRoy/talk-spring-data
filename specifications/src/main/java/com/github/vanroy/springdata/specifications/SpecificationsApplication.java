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

import static org.springframework.data.jpa.domain.Specifications.*;

@SpringBootApplication
public class SpecificationsApplication implements CommandLineRunner {

    static List<Person> SIMPSONS = Arrays.asList(
            new Person("Homer", "Simpson", 42),
            new Person("Abraham", "Simpson", 78),
            new Person("Ned", "Flanders", 46),
            new Person("Barney", "Gumble", 39),
            new Person("Lisa", "Simpson", 8)
    );

    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpecificationsApplication.class, args);
    }

    private static Specification<Person> personIsAdult() {
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("age"), 18);
    }

    private static Specification<Person> personIsASimpson() {
        return (root, query, cb) -> cb.equal(root.get("lastName"), "Simpson");
    }

    @Override
    public void run(String... args) throws Exception {

        personRepository.save(SIMPSONS);

        ConsoleOutput.write(
            this.personRepository.findAll(
                where(personIsASimpson()).and(personIsAdult())
            )
        );
    }
}
