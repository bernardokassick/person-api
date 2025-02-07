package com.personapi.person.application.service;

import com.personapi.person.application.dto.PersonDTO;
import com.personapi.person.application.exception.PersonNotFoundException;
import com.personapi.person.domain.entity.Person;
import com.personapi.person.application.dto.MessageResponseDTO;
import com.personapi.person.application.mapper.PersonMapper;
import com.personapi.person.application.action.PersonPort;
import com.personapi.person.infrastructure.repository.PersonRepository;
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

    public MessageResponseDTO createPerson(PersonDTO personDto){
        Person personToSave = personMapper.toModel(personDto);
        Person savedPerson = personRepository.save(personToSave);
        return creteMessageResponse(savedPerson.getId(), "Created person with Id: ");
    }

    public List<PersonDTO> findAll(){
    List<Person> allPeople = personRepository.findAll();

    return allPeople.stream().map(personMapper::toDto).collect(Collectors.toList());
    }

    public PersonDTO findPersonById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);

        return personMapper.toDto(person);
    }

    public MessageResponseDTO update(Long id, PersonDTO personDto) throws PersonNotFoundException {
        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDto);
        Person updatedPerson = personRepository.save(personToUpdate);
        return creteMessageResponse(updatedPerson.getId(), "Updated person with Id: ");
    }

    public void deleteById(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
       return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO creteMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder().
                message(message + id)
                .build();
    }

}
