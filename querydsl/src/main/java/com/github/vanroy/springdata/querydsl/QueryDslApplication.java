package com.github.vanroy.springdata.querydsl;

import com.github.vanroy.springdata.querydsl.model.Person;
import com.github.vanroy.springdata.querydsl.model.QPerson;
import com.github.vanroy.springdata.querydsl.repository.PersonRepository;
import com.github.vanroy.springdata.tools.output.ConsoleOutput;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class QueryDslApplication implements CommandLineRunner {

    static List<Person> SIMPSONS = Arrays.asList(
            new Person("Homer", "Simpson", 42),
            new Person("Abraham", "Simpson", 78),
            new Person("Ned", "Flanders", 46),
            new Person("Barney", "Gumble", 39),
            new Person("Lisa", "Simpson", 8)
    );

    @Autowired
    private PersonRepository personRepository;

	@Override
	public void run(String... args) throws Exception {

	    personRepository.saveAll(SIMPSONS);

        Predicate predicate = QPerson.person.firstName.equalsIgnoreCase("Barney");

        ConsoleOutput.write(this.personRepository.findAll(predicate));
	}

	public static void main(String[] args) {
		SpringApplication.run(QueryDslApplication.class, args);
	}
}
