package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.b.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.b.dtos.responses.car.GetCarResponse;
import com.tobeto.spring.b.dtos.responses.car.GetListCarResponse;
import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.entities.Model;
import com.tobeto.spring.b.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarsController {

    private final CarRepository carRepository;

    @GetMapping
    public List<GetListCarResponse> getAll(){
        List<Car> cars = carRepository.findAll();
        List<GetListCarResponse> carResponses = new ArrayList<GetListCarResponse>();
        for (Car car:cars
             ) {
            GetListCarResponse carResponse = new GetListCarResponse();


            carResponse.setId(car.getId());
            carResponse.setDailyPrice(car.getDailyPrice());
            carResponse.setStatus(car.getStatus());
            carResponse.setPlate(car.getPlate());

            carResponses.add(carResponse);


        }
        return carResponses;
    }
    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id){
        Car  car = carRepository.findById(id).orElseThrow();
        GetCarResponse carResponse = new GetCarResponse();
        carResponse.setDailyPrice(car.getDailyPrice());
        carResponse.setStatus(car.getStatus());
        carResponse.setPlate(car.getPlate());

        return carResponse;
    }
    @PostMapping
    public void add(@RequestBody AddCarRequest carRequest){
        Car car = new Car();
        Model model = new Model();
        model.setId(carRequest.getModelId());
        car.setModel(model);
        car.setDailyPrice(carRequest.getDailyPrice());
        car.setPlate(carRequest.getPlate());
        car.setStatus(carRequest.getStatus());
        carRepository.save(car);
    }
    @PutMapping
    public void update (@RequestBody UpdateCarRequest carRequest){
        Car car = new Car();
        car.setId(carRequest.getId());
        carRepository.findById(car.getId()).orElseThrow();
        Model model = new Model();
        model.setId(carRequest.getModelId());
        car.setModel(model);
        car.setDailyPrice(carRequest.getDailyPrice());
        car.setPlate(carRequest.getPlate());
        car.setStatus(carRequest.getStatus());
        carRepository.save(car);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }
}
