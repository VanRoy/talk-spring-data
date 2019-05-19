package com.github.vanroy.springdata.rest;

import com.github.vanroy.springdata.rest.model.Person;
import com.github.vanroy.springdata.rest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

	@Autowired
	PersonRepository personRepository;

	static List<Person> SIMPSONS = Arrays.asList(
        new Person("Homer", "Simpson", 42),
        new Person("Abraham", "Simpson", 78),
        new Person("Ned", "Flanders", 46),
        new Person("Barney", "Gumble", 39),
        new Person("Lisa", "Simpson", 8)
    );

	@PostConstruct
	void init() {
		personRepository.saveAll(SIMPSONS);
	}
}
