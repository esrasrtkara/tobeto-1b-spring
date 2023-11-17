package com.tobeto.spring.b.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "cars")
@Entity
public class Car {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "status")
    private int status;
    @Column(name = "daily_price")
    private int dailyPrice;
    @Column(name = "plate")
    private String plate;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @OneToMany(mappedBy = "car")
    private List<Order> orders;



}
