package com.github.vanroy.springdata.populator;

import com.github.vanroy.springdata.populator.output.ConsoleOutput;
import com.github.vanroy.springdata.populator.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@SpringBootApplication
public class PopulatorApplication implements CommandLineRunner {

    @Bean
    Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {
        Jackson2RepositoryPopulatorFactoryBean factoryBean = new Jackson2RepositoryPopulatorFactoryBean();
        factoryBean.setResources(new Resource[] { new ClassPathResource("persons.json") });
        return factoryBean;
    }

    @Autowired
    private PersonRepository personRepository;

    @Override
	public void run(String... args) throws Exception {
		ConsoleOutput.write(this.personRepository.findAll());
	}

	public static void main(String[] args) {
		SpringApplication.run(PopulatorApplication.class, args);
	}
}
