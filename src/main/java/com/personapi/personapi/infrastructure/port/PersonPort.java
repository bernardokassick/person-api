package com.personapi.personapi.infrastructure.port;

import com.personapi.personapi.infrastructure.dto.MessageResponseDto;
import com.personapi.personapi.infrastructure.dto.PersonDto;

import java.util.List;

public interface PersonPort {

    MessageResponseDto createPerson(PersonDto personDto);

    List<PersonDto> findAll();
}
