package com.example.CokeStudios.Service;

import com.example.CokeStudios.Entity.Seat;
import com.example.CokeStudios.Entity.Theatre;
import com.example.CokeStudios.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddTheatreService {

    @Autowired
    private TheatreRepository thRepo;

    public void addTheatre(Theatre theatre){

       //need to write more code
        for(int i=0;i<theatre.getCapacity();i++){
            Seat seat=new Seat();
            seat.setPrice(theatre.getPrice());
            seat.setTheatre(theatre);
            theatre.getSeats().add(seat);
        }

        System.out.println(theatre.toString());

        thRepo.save(theatre);

    }
    public Optional<Theatre> getTheatreById(int id){
        return thRepo.findById(id);
    }
    public List<Theatre> getAll(){
        return thRepo.findAll();
    }
}
