package com.example.SpringMvc.model;

import javax.persistence.*;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "price")
    private int price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private Place place;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Airline airLine;

    public Flight() {
    }

    public Flight(int price, Place place, Airline airLine) {
        this.price = price;
        this.place = place;
        this.airLine = airLine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Airline getAirLine() {
        return airLine;
    }

    public void setAirLine(Airline airLine) {
        this.airLine = airLine;
    }
}
