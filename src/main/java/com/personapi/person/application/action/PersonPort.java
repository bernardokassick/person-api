package com.personapi.person.application.action;

import com.personapi.person.application.dto.MessageResponseDto;
import com.personapi.person.application.exception.PersonNotFoundException;
import com.personapi.person.application.dto.PersonDto;

import java.util.List;

public interface PersonPort {

    MessageResponseDto createPerson(PersonDto personDto);

    List<PersonDto> findAll();

    PersonDto findPersonById(Long id) throws PersonNotFoundException;

    void deleteById(Long id) throws PersonNotFoundException;

    MessageResponseDto update(Long id, PersonDto personDto) throws PersonNotFoundException;
}
