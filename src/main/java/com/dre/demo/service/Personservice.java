package com.dre.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dre.demo.dao.PersonDao;
import com.dre.demo.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Personservice {
    private final PersonDao personDao;

    @Autowired
    public Personservice(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
    public List<Person> getAll(){
        return personDao.selectAll();
    }
    public Optional<Person> getPersonByID(UUID ID){
        return personDao.findPersonbyID(ID);
    }
}
