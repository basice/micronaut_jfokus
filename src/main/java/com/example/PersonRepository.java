package com.example;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import java.util.List;

@JdbcRepository(dialect = Dialect.H2)
public interface PersonRepository extends CrudRepository<Person, Long> {
  @Override
  public List<Person> findAll();

  public Person findByFirstName(String firstName);

  public Person findByAgeBetweenPerson(int start, int end);
}
