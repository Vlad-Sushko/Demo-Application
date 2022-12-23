package ua.sushko.RestApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ua.sushko.RestApplication.models.Person;
import ua.sushko.RestApplication.repositories.PersonRepository;

import java.time.LocalDate;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
		SpringApplication.run(RestApplication.class, args);
		PersonRepository personRepository =
				configurableApplicationContext.getBean(PersonRepository.class);
		Person myPerson = new Person("Vladyslav", "Sushko", LocalDate.of(1998,04,03));
		Person myPerson1 = new Person("Vasil", "Smetana", LocalDate.of(1990,02,23));
		Person myPerson2 = new Person("Ivan", "Mazepa", LocalDate.of(1999,12,12));
		Person myPerson3 = new Person("Mariia", "Malimon", LocalDate.of(1996,01,07));
		personRepository.save(myPerson);
		personRepository.save(myPerson1);
		personRepository.save(myPerson2);
		personRepository.save(myPerson3);

	}

}
