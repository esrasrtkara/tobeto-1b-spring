package com.tobeto.spring.b.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private int id;
    @Column(name = "rental_date")
     private LocalDate retalDate;
    @Column(name = "return_date")
     private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private  Car car;

}
