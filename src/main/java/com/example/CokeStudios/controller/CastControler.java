package com.example.CokeStudios.controller;

import com.example.CokeStudios.Entity.Cast;
import com.example.CokeStudios.Service.CastServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CastControler {

@Autowired
CastServices service;

@GetMapping("/cast/{id}")
public Optional<Cast> getCastById(@PathVariable int id){

    return service.getCast(id);
}


}
