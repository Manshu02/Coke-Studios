package com.example.CokeStudios.repository;


import com.example.CokeStudios.Entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Integer> {

    Theatre findByName(String name);
}
