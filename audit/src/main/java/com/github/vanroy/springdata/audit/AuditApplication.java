package com.github.vanroy.springdata.audit;

import com.github.vanroy.springdata.audit.model.Person;
import com.github.vanroy.springdata.audit.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableJpaAuditing
public class AuditApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuditApplication.class, args);
    }

    @Bean
    AuditorAware auditor() {
        return () -> Optional.of("admin");
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
