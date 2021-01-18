package com.dre.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dre.demo.model.Person;

public interface PersonDao {
    int insertPerson(UUID ID, Person person);
    default int insertPerson(Person person){
        UUID ID = UUID.randomUUID();
        return insertPerson(ID, person);
    }
    List<Person> selectAll();
    int deletepersone(UUID ID);
    int updatePerson(UUID ID,Person person);
    Optional<Person> findPersonbyID(UUID ID);
}
