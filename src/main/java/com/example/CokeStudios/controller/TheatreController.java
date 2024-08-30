package com.example.CokeStudios.controller;

import com.example.CokeStudios.Entity.Theatre;
import com.example.CokeStudios.Service.AddTheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TheatreController {

    @Autowired
    private AddTheatreService theatreService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/setTheatre")
    public void setTheatre(@RequestBody Theatre theatre){

        theatreService.addTheatre(theatre);
    }

    @GetMapping("/theatre/{id}")
    public Optional<Theatre> getTheatreById(@PathVariable int id){
        return theatreService.getTheatreById(id);
    }

    @GetMapping("/theatres")
    public List<Theatre> allTheatres(){
       return theatreService.getAll();
    }
 }
