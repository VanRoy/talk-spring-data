package com.github.vanroy.springdata.reactive.config;

import com.github.vanroy.springdata.reactive.model.Person;
import com.github.vanroy.springdata.reactive.service.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;

@Configuration
public class Config implements WebMvcConfigurer {

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
        template.createCollection("person", CollectionOptions.empty().size(1024 * 1024).maxDocuments(100).capped()).block();

        template.save(new Person("Homer", "Simpson", 42)).subscribe();

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(300000);
    }
}