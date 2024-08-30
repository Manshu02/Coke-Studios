package com.example.CokeStudios.controller;

import com.example.CokeStudios.Entity.Transaction;
import com.example.CokeStudios.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping("/addtransaction")
    public ResponseEntity<?> addTransaction(@RequestBody List<Transaction> list){
        return service.addTransaction(list);
    }
    @GetMapping("/gettransaction/{id}")
    public Optional<Transaction> getTransaction(@PathVariable int id){
        return service.getTransaction(id);
    }

    @GetMapping("/userTransactions/{name}")
    public List<Transaction> getTransactionsByUserId(@PathVariable String name) {
        return service.getTransactionsByUserId(name);
    }
}
