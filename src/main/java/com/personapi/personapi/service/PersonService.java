package com.personapi.personapi.service;

import com.personapi.personapi.domain.Person;
import com.personapi.personapi.infrastructure.dto.MessageResponseDto;
import com.personapi.personapi.infrastructure.dto.PersonDto;
import com.personapi.personapi.infrastructure.mapper.PersonMapper;
import com.personapi.personapi.infrastructure.port.PersonPort;
import com.personapi.personapi.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService implements PersonPort {

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

    public List<PersonDto> findAll(){
    List<Person> allPeople = personRepository.findAll();

    return allPeople.stream().map(personMapper::toDto).collect(Collectors.toList());
    }
}
