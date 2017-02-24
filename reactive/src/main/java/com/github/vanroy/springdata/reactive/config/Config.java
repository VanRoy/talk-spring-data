package com.github.vanroy.springdata.reactive.config;

import javax.annotation.PostConstruct;

import com.github.vanroy.springdata.reactive.model.Person;
import com.github.vanroy.springdata.reactive.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class Config {

    private final ReactiveMongoTemplate template;

    public Config(ReactiveMongoTemplate template) {
        this.template = template;
    }

    @Bean
    NotificationService<Person> notificationService() {
        return new NotificationService<>();
    }

    @PostConstruct
    void initMongoCollection() {

        template.dropCollection("person").block();
        template.createCollection("person", new CollectionOptions(1024 * 1024, 100, true)).block();

        template.save(new Person("Homer", "Simpson", 42)).subscribe();

    }

}
