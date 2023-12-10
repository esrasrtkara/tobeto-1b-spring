package com.tobeto.spring.b.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Table(name = "cars")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonIgnore
    @JoinColumn(name = "model_id")
    private Model model;
    @JsonIgnore
    @OneToMany(mappedBy = "car")
    private List<Order> orders;



}
