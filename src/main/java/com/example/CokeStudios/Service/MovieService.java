package com.example.CokeStudios.Service;

import com.example.CokeStudios.Entity.Cast;
import com.example.CokeStudios.Entity.Movie;
import com.example.CokeStudios.repository.CastRepository;
import com.example.CokeStudios.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private CastRepository castRepository;

    @Autowired
    private MovieRepository movieRepository;

    public void addMovie(Movie movie){
        List<Cast> existingCasts=new ArrayList<>();



        // Process the list of casts
        for (Cast cast : movie.getCasts()) {
            Cast existingCast = castRepository.findByName(cast.getName());
            if(existingCast != null) {
                existingCasts.add(existingCast);
            } else {
                existingCasts.add(cast);
            }
        }

        // Set the processed casts to the movie
        movie.setCasts(existingCasts);

        // Ensure bi-directional consistency
        for (Cast cast : existingCasts) {
            cast.getMovies().add(movie);
        }

        // Save the movie (this will also save the casts due to cascading)
        movieRepository.save(movie);


    }
    public Optional<Movie> getMovie(int id){
        return movieRepository.findById(id);
    }
    public List<Movie> getAll(){
        return movieRepository.findAll();
    }
}
