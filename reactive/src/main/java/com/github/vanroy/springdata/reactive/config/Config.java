package com.github.vanroy.springdata.reactive.config;

import com.github.vanroy.springdata.reactive.model.Person;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import javax.annotation.PostConstruct;

@Configuration
public class Config {

    private final ReactiveMongoTemplate template;

    public Config(ReactiveMongoTemplate template) {
        this.template = template;
    }

    @PostConstruct
    void initMongoCollection() {

        template.dropCollection("person").block();
        template.createCollection("person", CollectionOptions.empty().size(1024 * 1024).maxDocuments(100).capped()).block();

        template.save(new Person("Homer", "Simpson", 42)).subscribe();

    }
}
