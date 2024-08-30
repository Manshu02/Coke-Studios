package com.example.CokeStudios.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean isBooked=false;

    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE} ,fetch=FetchType.EAGER)
    @JsonIgnoreProperties(value = {"seats","transactions"})
    private Theatre theatre;

    @OneToMany(mappedBy = "seat",cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.EAGER)
    @JsonIgnoreProperties(value = {"theatre","seat","show"})
    private List<Transaction> transactions;


    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", isBooked=" + isBooked +
                ", price=" + price +
                '}';
    }
}
