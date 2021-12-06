package com.personapi.personapi.infrastructure.mapper;

import com.personapi.personapi.domain.Person;
import com.personapi.personapi.infrastructure.dto.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDto personDto);

    PersonDto toDto(Person person);


}
