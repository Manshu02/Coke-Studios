package com.example.CokeStudios.repository;

import com.example.CokeStudios.Entity.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow,Integer> {
}
