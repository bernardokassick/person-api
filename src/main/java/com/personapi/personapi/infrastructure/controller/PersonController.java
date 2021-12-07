package com.personapi.personapi.infrastructure.controller;

import com.personapi.personapi.commons.exceptions.PersonNotFoundExcepetion;
import com.personapi.personapi.infrastructure.dto.MessageResponseDto;
import com.personapi.personapi.infrastructure.dto.PersonDto;
import com.personapi.personapi.infrastructure.port.PersonPort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonPort personPort;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto createPerson(@RequestBody @Valid PersonDto personDto){
        return personPort.createPerson(personDto);
    }

    @GetMapping
    public List<PersonDto> getAll(){
        return personPort.findAll();
    }

    @GetMapping("/{id}")
    public PersonDto getPerson(@PathVariable Long id) throws PersonNotFoundExcepetion {
        return personPort.findPersonById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDto update(@PathVariable Long id, @RequestBody PersonDto personDto) throws PersonNotFoundExcepetion {

        return personPort.update(id, personDto);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable Long id) throws PersonNotFoundExcepetion {
        personPort.deleteById(id);
    }



}
