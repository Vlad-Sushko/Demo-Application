package ua.sushko.RestApplication.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ua.sushko.RestApplication.RestApplication;
import ua.sushko.RestApplication.models.Person;

import java.time.LocalDate;

class PersonRepositoryTest {

    @Test
    void CreateAndFindById() {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(RestApplication.class);
        PersonRepository personRepository =
                configurableApplicationContext.getBean(PersonRepository.class);
        Person myPerson = new Person("Vladyslav", "Sushko", LocalDate.of(1998,04,03));
        Person myPerson1 = new Person("Igor", "Smetana", LocalDate.of(1990,02,23));
        Person myPerson2 = new Person("Ivan", "Mazepa", LocalDate.of(1999,12,12));
        personRepository.save(myPerson);
        personRepository.save(myPerson1);
        personRepository.save(myPerson2);
        personRepository.findById(1L);
        personRepository.findById(2L);
        personRepository.findById(3L);

    }
}