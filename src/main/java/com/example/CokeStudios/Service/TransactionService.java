package com.example.CokeStudios.Service;

import com.example.CokeStudios.Entity.*;
import com.example.CokeStudios.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private MovieShowRepository showRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private UserRepo userRepo;

    public ResponseEntity<?> addTransaction(List<Transaction> list){
        List<Transaction> list2=new ArrayList<>();
        for(Transaction t:list){

           Seat seat =seatRepository.findById(t.getSeat().getId()) .orElseThrow(() -> new NoSuchElementException("Seat not found for ID: " + t.getSeat().getId()));
            list2=seat.getTransactions();
           list2.add(t);
           seat.setTransactions(list2);
           t.setSeat(seat);

            MovieShow show=showRepository.findById(t.getShow().getId()).orElseThrow(() -> new NoSuchElementException("show not found for ID: " + t.getSeat().getId()));
            list2=show.getTransactions();
            list2.add(t);
            show.setTransactions(list2);
            t.setShow(show);

            Theatre theatre=theatreRepository.findByName(t.getTheatre().getName());
            list2=theatre.getTransactions();
            list2.add(t);
            theatre.setTransactions(list2);
            t.setTheatre(theatre);

            Users user =userRepo.findByuname(t.getUser().getUname());
            list2=user.getTransactions();
            list2.add(t);
            user.setTransactions(list2);
            t.setUser(user);

            transactionRepo.save(t);
        }
        return ResponseEntity.ok("transactions Added");
    }
    public Optional<Transaction> getTransaction(int id){
        return transactionRepo.findById(id);
    }
    public List<Transaction> getTransactionsByUserId(String name) {
        Users user =userRepo.findByuname(name);
        List<Transaction> transactions=user.getTransactions();
        return transactions;
    }

}
