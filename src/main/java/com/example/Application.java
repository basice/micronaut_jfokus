package com.example;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Singleton;
import java.util.List;
import javax.transaction.Transactional;

@Singleton
public class Application {

  private final PersonRepository repository;

  public static void main(String[] args) {
    Micronaut.run(Application.class, args);
  }

  public Application(PersonRepository repository) {
    this.repository = repository;
  }

  @EventListener
  @Transactional
  void onStartup(StartupEvent event) {
    repository.saveAll(
      List.of(
        new Person("Fred", "Flinstone", 45),
        new Person("Barney", "Rubble", 35)
      )
    );
  }
}
