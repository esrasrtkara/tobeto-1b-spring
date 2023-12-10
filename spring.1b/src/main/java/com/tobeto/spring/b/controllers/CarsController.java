package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.sevices.abstracts.CarService;
import com.tobeto.spring.b.sevices.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.b.sevices.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.b.sevices.dtos.responses.car.GetCarResponse;
import com.tobeto.spring.b.sevices.dtos.responses.car.GetListCarResponse;
import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.entities.Model;
import com.tobeto.spring.b.repositories.CarRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarsController {

    private final CarService carService;

    @GetMapping
    public List<GetListCarResponse> getAll(){
        return carService.getAll();
    }
    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id){
        return carService.getById(id);
    }
    @GetMapping("GetByPlate")
    public List<GetListCarResponse> getByPlate(@RequestParam String plate){
        return carService.getByPlate(plate);
    }
    @GetMapping("OrderPlate")
    public List<GetListCarResponse> getByStatusOrderByDailyPriceDesc(int status){
        return carService.getByStatusOrderByDailyPriceDesc(status);
    }
    @GetMapping("search")
    public List<GetListCarResponse> search(){
      return   carService.search();
    }
    @GetMapping("searchRentCar")
    public List<GetListCarResponse> search(@RequestParam int status){
        return carService.searchRentCar(status);
    }
    @PostMapping
    public void add(@RequestBody @Valid AddCarRequest carRequest){
       carService.add(carRequest);
    }
    @PutMapping
    public void update (@RequestBody UpdateCarRequest carRequest){
        carService.update(carRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carService.delete(id);
    }
}
