package com.tobeto.spring.b;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/persons") // Bu controllerın kontrol edeceği alt routeları tanımlamak
public class PersonsController {

    // In memory db
    // CRUD => Create,Read,Update,Delete
    List<Person> inMemoryList = new ArrayList<>();
    @GetMapping // api/persons
    public List<Person> get(){

        return inMemoryList;
    }
    //query string , path variable
    //path =>
/*    @GetMapping("getById") // api/persons/get2
    public int getById(@RequestParam int id){

        return id;
    }*/
    @GetMapping("/{id}")
    public Person getById(@PathVariable int id) {
        //Lammbda Expressions
        //Stream API

        Person person = inMemoryList
                .stream()
                //Lambda Expression
                .filter((p)->p.getId() == id).findFirst()
                .orElseThrow();

        return person;
    }
    @PostMapping
    public void add(@RequestBody Person person){
        inMemoryList.add(person);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Person updatedPerson) {
        Person person = getById(id);
        person.setAge(updatedPerson.getAge());
        person.setName(updatedPerson.getName());
        person.setSurname(updatedPerson.getSurname());
    }

    @DeleteMapping("{id}")
    public  void delete(@PathVariable int id) {
        Person personToRemove = getById(id);
        inMemoryList.remove(personToRemove);
    }
}
