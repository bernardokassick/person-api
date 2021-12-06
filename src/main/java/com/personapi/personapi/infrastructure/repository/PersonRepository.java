package com.personapi.personapi.infrastructure.repository;

import com.personapi.personapi.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
