package com.personapi.personapi.service;

import com.personapi.personapi.domain.Person;
import com.personapi.personapi.infrastructure.dto.MessageResponseDto;
import com.personapi.personapi.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MessageResponseDto createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDto.builder().message("Created person with ID " + savedPerson.getId()).build();
    }
}
