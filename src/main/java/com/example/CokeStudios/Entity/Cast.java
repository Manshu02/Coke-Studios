package com.example.CokeStudios.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Cast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cId;

    private String name;

    @ManyToMany ( mappedBy = "casts",cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
    @JsonIgnoreProperties("casts")
    private List<Movie> movies=new ArrayList<>();

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
