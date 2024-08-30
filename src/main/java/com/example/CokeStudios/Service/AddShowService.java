package com.example.CokeStudios.Service;

import com.example.CokeStudios.Entity.Movie;
import com.example.CokeStudios.Entity.MovieShow;
import com.example.CokeStudios.Entity.Theatre;
import com.example.CokeStudios.repository.MovieRepository;
import com.example.CokeStudios.repository.MovieShowRepository;
import com.example.CokeStudios.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddShowService {

    @Autowired
    MovieShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    public void setShow(MovieShow show){
//        show.getMovie().getMovieShows().add(show);
//        show.getTheatre().getShows().add(show);

        Movie movie=movieRepository.findByMName(show.getMovie().getmName());
        movie.getMovieShows().add(show);
        show.setMovie(movie);

        Theatre theatre=theatreRepository.findByName(show.getTheatre().getName());
        theatre.getMovieShows().add(show);
        show.setTheatre(theatre);
        showRepository.save(show);
    }
    public Optional<MovieShow> getShowById(int id){
        return showRepository.findById(id);
    }

    public List<MovieShow> getAll(){
        return showRepository.findAll();
    }
}
