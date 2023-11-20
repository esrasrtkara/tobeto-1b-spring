package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarsController {

    private final CarRepository carRepository;

    @GetMapping
    public List<Car> getAll(){
        return carRepository.findAll();
    }
    @GetMapping("{id}")
    public Car getById(@PathVariable int id){
        return carRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Car car){
        carRepository.save(car);
    }
    @PutMapping
    public void update (@RequestBody Car car){
        carRepository.findById(car.getId()).orElseThrow();
        carRepository.save(car);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }
}
