package com.personapi.personapi.infrastructure.port;

import com.personapi.personapi.commons.exceptions.PersonNotFoundExcepetion;
import com.personapi.personapi.infrastructure.dto.MessageResponseDto;
import com.personapi.personapi.infrastructure.dto.PersonDto;

import java.util.List;

public interface PersonPort {

    MessageResponseDto createPerson(PersonDto personDto);

    List<PersonDto> findAll();

    PersonDto findPersonById(Long id) throws PersonNotFoundExcepetion;

    void deleteById(Long id) throws PersonNotFoundExcepetion;

    MessageResponseDto update(Long id, PersonDto personDto) throws PersonNotFoundExcepetion;
}
