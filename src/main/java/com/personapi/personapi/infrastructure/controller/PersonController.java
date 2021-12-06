package com.personapi.personapi.infrastructure.controller;

import com.personapi.personapi.domain.Person;
import com.personapi.personapi.infrastructure.dto.MessageResponseDto;
import com.personapi.personapi.infrastructure.dto.PersonDto;
import com.personapi.personapi.infrastructure.port.PersonPort;
import com.personapi.personapi.infrastructure.repository.PersonRepository;
import com.personapi.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonPort personPort;

    @Autowired
    public PersonController(PersonPort personPort) {
        this.personPort = personPort;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto createPerson(@RequestBody @Valid PersonDto personDto){
        return personPort.createPerson(personDto);
    }

    @GetMapping
    public List<PersonDto> getAll(){
        return personPort.findAll();
    }
}
