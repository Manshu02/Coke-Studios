package com.example.CokeStudios.repository;

import com.example.CokeStudios.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findByMName(String mName);
}
