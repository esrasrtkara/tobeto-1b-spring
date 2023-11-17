package com.tobeto.spring.b.entities;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "address")
    private  String address;
    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;


}
