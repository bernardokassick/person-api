package com.personapi.personapi.service;

import com.personapi.personapi.domain.Person;
import com.personapi.personapi.infrastructure.dto.MessageResponseDto;
import com.personapi.personapi.infrastructure.dto.PersonDto;
import com.personapi.personapi.infrastructure.mapper.PersonMapper;
import com.personapi.personapi.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MessageResponseDto createPerson(PersonDto personDto){
        Person personToSave = personMapper.toModel(personDto);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDto
                .builder().
                message("Created person with ID " + savedPerson.getId())
                .build();
    }
}
