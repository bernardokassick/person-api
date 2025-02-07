package com.personapi.person.application.action;

import com.personapi.person.application.dto.MessageResponseDTO;
import com.personapi.person.application.dto.PersonDTO;
import com.personapi.person.application.exception.PersonNotFoundException;

import java.util.List;

public interface PersonPort {

    MessageResponseDTO createPerson(PersonDTO personDto);

    List<PersonDTO> findAll();

    PersonDTO findPersonById(Long id) throws PersonNotFoundException;

    void deleteById(Long id) throws PersonNotFoundException;

    MessageResponseDTO update(Long id, PersonDTO personDto) throws PersonNotFoundException;
}
