//package com.personapi.application.service;
//
//import com.personapi.person.application.dto.MessageResponseDTO;
//import com.personapi.person.application.dto.PersonDTO;
//import com.personapi.person.application.mapper.PersonMapper;
//import com.personapi.person.application.service.PersonService;
//import com.personapi.person.domain.entity.Person;
//import com.personapi.person.infrastructure.repository.PersonRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.time.LocalDate;
//
//import static org.hamcrest.Matchers.any;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class PersonServiceTest {
//
//    @InjectMocks
//    private PersonService service;
//
//    @Mock
//    private PersonRepository repository;
//
//    @Mock
//    private PersonMapper mapper;
//
//    @Test
//    void whenCreate_givenPersonToSaveAndNotErrorInSaveProcess_mustReturnGeneratedIdInSave() {
//        Person person = mock(Person.class);
//        when(person.getId()).thenReturn(1L);
//        when(person.getFirstName()).thenReturn("name");
//
//        when(this.mapper.toModel(any(PersonDTO.class))).thenReturn(person);
//        when(this.personRepository.save(any(Person.class))).thenReturn(person);
//
//        assertEquals(1L, this.createPersonService.create(mock(PersonCreateDTO.class)));
//    }
//
//
//}
