package com.github.vanroy.springdata.cassandra;

import java.util.Arrays;
import java.util.List;

import com.github.vanroy.springdata.cassandra.model.Person;
import com.github.vanroy.springdata.cassandra.repository.PersonRepository;
import com.github.vanroy.springdata.tools.output.ConsoleOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CassandraApplication implements CommandLineRunner {

    Person HOMER = new Person("Homer", "Simpson", 42);
    Person ABRAHAM = new Person("Abraham", "Simpson", 78);
    Person NED = new Person("Ned", "Flanders", 46);
    Person BARNEY = new Person("Barney", "Gumble", 39);
    Person LISA = new Person("Lisa", "Simpson", 8);

	List<Person> SIMPSONS = Arrays.asList(HOMER, ABRAHAM, NED, BARNEY, LISA);

    @Autowired
    private PersonRepository personRepository;

	@Override
	public void run(String... args) throws Exception {

	    personRepository.save(SIMPSONS);

        ConsoleOutput.write(this.personRepository.findAll());

        ConsoleOutput.write(this.personRepository.findByLastName("Simpson"));

        ConsoleOutput.write(this.personRepository.findByLastNameAndFirstName("Gumble", "Barney"));
	}

	public static void main(String[] args) {
		SpringApplication.run(CassandraApplication.class, args);
	}
}
