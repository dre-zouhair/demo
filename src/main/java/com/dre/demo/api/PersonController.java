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

@RequestMapping("/")
@RestController
// @CrossOrigin
public class PersonController {
    private final Personservice personService;

    @GetMapping()
    public String home() {
        personService.addPerson(new Person(UUID.randomUUID(),"zouhair dre"));
        personService.addPerson(new Person(UUID.randomUUID(),"ali dre"));
        return "try : </br> /spring </br>  or /bonjour/{your essage here}  </br>  or /all to get all list of names  </br>  or /all/{ID} to get by ID"
        +" </br> or you can add a person using postman to send a POST request to https://demo-dosi-java-deploy.herokuapp.com with </br>{</br>"+
         "  </br>     \"name\" :\"a name to add\""+
        "     </br>   }";
    }

    @GetMapping("/spring")
    public String test() {
        return "Heloo World from Spring";
    }
    @GetMapping(path = "/bonjour/{name}")
    public String message(@PathVariable("name") String name) {        
        return "Bonjour : "+name;
    }
    @Autowired
    public PersonController(Personservice personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping("/all")
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping(path = "/all/{id}")
    public Person  findByID(@PathVariable("id") UUID ID) {
        return personService.getPersonByID(ID).orElse(null);
    }
}

