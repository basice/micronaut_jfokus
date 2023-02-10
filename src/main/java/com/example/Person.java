package com.example;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

@MappedEntity
public record Person(
  @GeneratedValue @Id @Nullable Long id,
  String firstName,
  String lastName,
  int age
) {
  public Person(String firstName, String lastName, int age) {
    this(null, firstName, lastName, age);
  }
}
