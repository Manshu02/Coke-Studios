package com.example.CokeStudios.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int mId;

    private String mName;

    @ManyToMany(cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
    @JoinTable(
            name = "movie_cast",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "cast_id")
    )
    @JsonIgnoreProperties("movies")
    private List<Cast> casts=new ArrayList<>();

    @OneToMany(mappedBy = "movie",cascade={CascadeType.PERSIST,CascadeType.MERGE} ,fetch=FetchType.EAGER)
    @JsonIgnoreProperties("movie")
    private List<MovieShow> movieShows =new ArrayList<>();



    public List<MovieShow> getMovieShows() {
        return movieShows;
    }

    public void setMovieShows(List<MovieShow> movieShows) {
        this.movieShows = movieShows;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public List<Cast> getCasts() {
        return casts;
    }

    public void setCasts(List<Cast> casts) {
        this.casts = casts;
    }
}
