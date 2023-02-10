package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.PersonTest.PersonClient;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import java.util.List;
import org.junit.jupiter.api.Test;

@MicronautTest
public class PersonTest {

    @Test
    void testListPeople(PersonClient client) {
        List<Person> people = client.list();

        assertEquals(2, people.size());
    }

    @Client("/people")
    interface PersonClient {
        @Get
        List<Person> list();
    }
}
