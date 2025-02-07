package com.personapi.person.presentation.api.controller;

import com.personapi.person.application.dto.PersonDTO;
import com.personapi.person.application.exception.PersonNotFoundException;
import com.personapi.person.application.dto.MessageResponseDTO;
import com.personapi.person.application.action.PersonPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor()
public class PersonController {

    private PersonPort personPort;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDto){
        return personPort.createPerson(personDto);
    }

    @GetMapping
    public List<PersonDTO> getAll(){
        return personPort.findAll();
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable Long id) throws PersonNotFoundException {
        return personPort.findPersonById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody PersonDTO personDto) throws PersonNotFoundException {

        return personPort.update(id, personDto);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable Long id) throws PersonNotFoundException {
        personPort.deleteById(id);
    }



}
