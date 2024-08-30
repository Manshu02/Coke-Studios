package com.example.CokeStudios.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class MovieShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE} ,fetch=FetchType.EAGER)
    @JsonIgnoreProperties("movieShows")
    private Movie movie;

    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE} ,fetch=FetchType.EAGER)
    @JsonIgnoreProperties(value = {"movieShows","transactions"})
    private Theatre theatre;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    @OneToMany(mappedBy = "show",cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.EAGER)
    @JsonIgnoreProperties(value = {"theatre","transactions","show"})
    private List<Transaction> transactions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "MovieShow{" +
                "id=" + id +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
