package com.example.CokeStudios.repository;

import com.example.CokeStudios.Entity.Cast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastRepository extends JpaRepository<Cast,Integer> {
    Cast findByName(String Name);
}
