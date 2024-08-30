//package com.example.FakeTaxi.controller;
//
//
//import com.example.FakeTaxi.Entity.Person;
//import com.example.FakeTaxi.Service.PersonServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//
//@RestController
//public class PersonInfoController {
//
//@Autowired
//private PersonServices service;
//
//
//@PostMapping("/person")
//public void enterPerson(@RequestBody Person person){
//    service.addPerson(person);
//}
//
//@GetMapping("/person/{id}")
//    public Optional<Person> getPersonById(@PathVariable int id){
//
//    return service.getPerson(id);
//
//}
//
//}
