package com.tobeto.spring.b.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "models")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "year")
    private  int year;
    @Column(name = "color")
    private String color;
    @Column(name = "fuel")
    private String fuel;
    @Column(name = "gear")
    private String gear;
    @Column(name = "case_type")
    private String caseType;

    @ManyToOne
    @JoinColumn(name = "brand_id")
   // @JsonIgnore
    private Brand brand;

    @OneToMany(mappedBy = "model")
    @JsonIgnore  // bu aşan jsona çevrilirken yok sayılacak
    private List<Car> cars;


}
