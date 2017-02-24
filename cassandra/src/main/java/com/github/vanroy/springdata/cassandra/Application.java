package com.github.vanroy.springdata.cassandra;

import com.github.vanroy.springdata.cassandra.model.Person;
import com.github.vanroy.springdata.cassandra.output.ConsoleOutput;
import com.github.vanroy.springdata.cassandra.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    Person HOMER = new Person("Homer", "Simpson", 42);
    Person ABRAHAM = new Person("Abraham", "Simpson", 78);
    Person NED = new Person("Ned", "Flanders", 46);
    Person BARNEY = new Person("Barney", "Gumble", 39);
    Person LISA = new Person("Lisa", "Simpson", 8);

    @Autowired
    private PersonRepository personRepository;

    //@Autowired
    //private CassandraTemplate CassandraTemplate;
    //	    cassandraTemplate.execute(CreateIndexSpecification.createIndex().tableName("person").columnName("age"));

	@Override
	public void run(String... args) throws Exception {

	    personRepository.save(HOMER);
	    personRepository.save(ABRAHAM);
	    personRepository.save(NED);
	    personRepository.save(BARNEY);
	    personRepository.save(LISA);

        ConsoleOutput.write(this.personRepository.findAll());

        ConsoleOutput.write(this.personRepository.findByLastName("Simpson"));

        ConsoleOutput.write(this.personRepository.findByLastNameAndFirstName("Gumble", "Barney"));
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
