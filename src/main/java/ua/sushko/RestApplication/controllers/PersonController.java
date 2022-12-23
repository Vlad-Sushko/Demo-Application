package ua.sushko.RestApplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.sushko.RestApplication.dto.PersonDTO;
import ua.sushko.RestApplication.services.PersonService;
import ua.sushko.RestApplication.util.PersonErrorResponse;
import ua.sushko.RestApplication.util.PersonNotFoundException;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException e) {
        PersonErrorResponse response = new PersonErrorResponse(
                "There is no person with that id!"
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
