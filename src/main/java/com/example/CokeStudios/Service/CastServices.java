package com.example.CokeStudios.Service;

import com.example.CokeStudios.Entity.Cast;
import com.example.CokeStudios.repository.CastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CastServices {

@Autowired
CastRepository castRepo;


public Optional<Cast> getCast(int id){
    return castRepo.findById(id);
}
}
