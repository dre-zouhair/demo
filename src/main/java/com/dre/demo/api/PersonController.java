package com.dre.demo.api;

import java.util.List;
//import java.util.Optional;
import java.util.UUID;
import com.dre.demo.model.Person;
import com.dre.demo.service.Personservice;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/dosi")
@RestController
// @CrossOrigin
public class PersonController {
    private final Personservice personService;

    @GetMapping("/helloworld")
    public String home() {
        return "Heloo World";
    }

    @GetMapping("/spring")
    public String test() {
        return "Heloo World from Spring";
    }

    @Autowired
    public PersonController(Personservice personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping(path = "{id}")
    public Person  findByID(@PathVariable("id") UUID ID) {
        return personService.getPersonByID(ID).orElse(null);
    }
}

