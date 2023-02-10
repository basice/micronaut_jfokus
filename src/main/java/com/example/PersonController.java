package com.example;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import java.util.List;

@Controller("/people")
public class PersonController {
    
    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @Get
    List<Person> list() {
        return repository.findAll();
    }

    @Get("/{firstName}")
    @Nullable
    Person get(String firstName) {
        return repository.findByFirstName(firstName);
    }
}
