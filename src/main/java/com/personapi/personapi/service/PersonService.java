package com.personapi.personapi.service;

import com.personapi.personapi.commons.exceptions.PersonNotFoundExcepetion;
import com.personapi.personapi.domain.Person;
import com.personapi.personapi.infrastructure.dto.MessageResponseDto;
import com.personapi.personapi.infrastructure.dto.PersonDto;
import com.personapi.personapi.infrastructure.mapper.PersonMapper;
import com.personapi.personapi.infrastructure.port.PersonPort;
import com.personapi.personapi.infrastructure.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService implements PersonPort {

    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDto createPerson(PersonDto personDto){
        Person personToSave = personMapper.toModel(personDto);
        Person savedPerson = personRepository.save(personToSave);
        return creteMessageResponse(savedPerson.getId(), "Created person with Id: ");
    }

    public List<PersonDto> findAll(){
    List<Person> allPeople = personRepository.findAll();

    return allPeople.stream().map(personMapper::toDto).collect(Collectors.toList());
    }

    public PersonDto findPersonById(Long id) throws PersonNotFoundExcepetion {
        Person person = verifyIfExists(id);

        return personMapper.toDto(person);
    }

    public MessageResponseDto update(Long id, PersonDto personDto) throws PersonNotFoundExcepetion {
        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDto);
        Person updatedPerson = personRepository.save(personToUpdate);
        return creteMessageResponse(updatedPerson.getId(), "Updated person with Id: ");
    }

    public void deleteById(Long id) throws PersonNotFoundExcepetion {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundExcepetion{
       return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundExcepetion(id));
    }

    private MessageResponseDto creteMessageResponse(Long id, String message) {
        return MessageResponseDto
                .builder().
                message(message + id)
                .build();
    }

}
