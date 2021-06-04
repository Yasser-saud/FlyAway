package com.example.SpringMvc.model;

import javax.persistence.*;

@Entity
@Table(name = "airline")
public class AirLine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "name")
    private String name;

    public AirLine() {
    }

    public AirLine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}