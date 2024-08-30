package com.example.CokeStudios.controller;

import com.example.CokeStudios.Entity.Movie;
import com.example.CokeStudios.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

@Autowired
   private MovieService service;

@CrossOrigin(origins = "http://localhost:3000")
@PostMapping("/setmovie")
    public void setMovie(@RequestBody Movie movie){
    service.addMovie(movie);
}

    @GetMapping("/movie/{id}")
    public Optional<Movie> getPersonById(@PathVariable int id){

        return service.getMovie(id);

    }

    @GetMapping("/movies")
    public List<Movie> getAll(){
    return service.getAll();
    }
}
