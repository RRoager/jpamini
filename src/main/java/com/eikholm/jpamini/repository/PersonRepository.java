package com.eikholm.jpamini.repository;

import com.eikholm.jpamini.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Long> {
}
