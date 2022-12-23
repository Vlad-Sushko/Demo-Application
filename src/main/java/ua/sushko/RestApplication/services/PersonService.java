package ua.sushko.RestApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.sushko.RestApplication.dto.PersonDTO;
import ua.sushko.RestApplication.models.Person;
import ua.sushko.RestApplication.repositories.PersonRepository;
import ua.sushko.RestApplication.util.PersonNotFoundException;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

        public PersonDTO findById(Long id) {
            Optional<Person> foundPerson = personRepository.findById(id);

            if (foundPerson.isPresent()) {
                PersonDTO personDTO = new PersonDTO();
                personDTO.setId(foundPerson.get().getId());
                personDTO.setName(foundPerson.get().getName());
                personDTO.setSurname(foundPerson.get().getSurname());
                personDTO.setAge(calculateAge(foundPerson.get().getDateOfBirth(), LocalDate.now()));
                return personDTO;
            } else {
                throw new PersonNotFoundException();
            }
        }

        public void createPerson(Person person) {
        Person newPerson = new Person();
        personRepository.save(person);
    }


    public int calculateAge(
            LocalDate birthDate,
            LocalDate currentDate) {
        return Period.between(birthDate, currentDate).getYears();
    }

    }

