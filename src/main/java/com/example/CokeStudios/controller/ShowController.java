package com.example.CokeStudios.controller;

import com.example.CokeStudios.Entity.MovieShow;
import com.example.CokeStudios.Service.AddShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShowController {

    @Autowired
    AddShowService showService;

    @PostMapping("/addShow")
    public void addShow(@RequestBody MovieShow show){

        showService.setShow(show);
    }

    @GetMapping("/getShow/{id}")
    public Optional<MovieShow> getShow(@PathVariable int id){
        return showService.getShowById(id);
    }
    @GetMapping("/allmovieshows")
    public List<MovieShow> getAll(){

       return showService.getAll();
    }

}
