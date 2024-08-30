package com.example.CokeStudios.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date date;

    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE} ,fetch=FetchType.EAGER)
    @JsonIgnoreProperties(value = {"transactions","movieShows","seats"})
    private Theatre theatre;

    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE} ,fetch=FetchType.EAGER)
    @JsonIgnoreProperties("transactions")
    private Users user;

    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE} ,fetch=FetchType.EAGER)
    @JsonIgnoreProperties(value = {"transactions","theatre"})
    private MovieShow show;

    private LocalTime time;

    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE} ,fetch=FetchType.EAGER)
    @JsonIgnoreProperties(value = {"transactions","theatre"})
    private Seat seat;

    private  int amount;

    private int seatNo;

    private String paymentId;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public MovieShow getShow() {
        return show;
    }

    public void setShow(MovieShow show) {
        this.show = show;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", amount=" + amount +
                ", seatNo=" + seatNo +
                '}';
    }
}
