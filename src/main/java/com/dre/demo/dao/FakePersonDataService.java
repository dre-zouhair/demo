package com.dre.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dre.demo.model.Person;

import org.springframework.stereotype.Repository;

@Repository("fakeDao")
public class FakePersonDataService implements PersonDao {
    public static List<Person> list = new ArrayList<>();

    @Override
    public int insertPerson(UUID ID, Person person) {
        list.add(new Person(ID, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAll() {
        return list;
    }

    @Override
    public int deletepersone(UUID ID) {
       
        return 0;
    }

    @Override
    public int updatePerson(UUID ID, Person person) {
       
        return 0;
    }

    @Override
    public Optional<Person> findPersonbyID(UUID ID) {
        
        return list.stream().filter(person -> person.getID().equals(ID)).findFirst();
    }
    
}
