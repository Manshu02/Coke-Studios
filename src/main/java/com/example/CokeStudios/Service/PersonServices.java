//package com.example.FakeTaxi.Service;
//
//import com.example.FakeTaxi.Entity.Car;
//import com.example.FakeTaxi.Entity.Person;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class PersonServices {
//
//
//@Autowired
//private PersonRepository repo;
//
//public void addPerson(Person person){
//
//    List<Car> cars=person.getCars();
//
//    for(int i=0;i<cars.size();i++){
//        Car car=cars.get(i);
//        car.setPerson(person);//important to set foreign key in cars table
//    }
//
//    repo.save(person);
//}
//
//public Optional<Person> getPerson(int id){
//    return repo.findById(id);
//}
//}
