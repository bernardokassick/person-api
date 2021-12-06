package com.personapi.personapi.infrastructure.controller;

import com.personapi.personapi.domain.Person;
import com.personapi.personapi.infrastructure.dto.MessageResponseDto;
import com.personapi.personapi.infrastructure.dto.PersonDto;
import com.personapi.personapi.infrastructure.repository.PersonRepository;
import com.personapi.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;
    private PersonService personService;

    @Autowired
    public PersonController(PersonRepository personRepository, PersonService personService) {
        this.personRepository = personRepository;
        this.personService = personService;
    }

    @GetMapping
    public String getBook(){

        return "Hello friend!";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto createPerson(@RequestBody @Valid PersonDto personDto){
        return personService.createPerson(personDto);
    }
}
