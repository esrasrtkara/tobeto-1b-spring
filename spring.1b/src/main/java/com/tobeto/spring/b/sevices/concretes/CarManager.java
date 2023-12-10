package com.tobeto.spring.b.sevices.concretes;

import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.entities.Model;
import com.tobeto.spring.b.repositories.CarRepository;
import com.tobeto.spring.b.sevices.abstracts.CarService;
import com.tobeto.spring.b.sevices.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.b.sevices.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.b.sevices.dtos.responses.car.GetCarResponse;
import com.tobeto.spring.b.sevices.dtos.responses.car.GetListCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CarManager implements CarService {

    private  final CarRepository carRepository;
    @Override
    public List<GetListCarResponse> getAll() {
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

    @Override
    public List<GetListCarResponse> getByPlate(String plate) {
        List<Car> cars = carRepository.findByPlate(plate);
        List<GetListCarResponse> responses = new ArrayList<>();

        for (Car car:cars
             ) {
            GetListCarResponse response = new GetListCarResponse(car.getId(), car.getStatus(), car.getDailyPrice(), car.getPlate());
            responses.add(response);
        }
        return responses;
    }

    @Override
    public List<GetListCarResponse> getByStatusOrderByDailyPriceDesc(int status) {
        List<Car> cars = carRepository.findByStatusOrderByDailyPriceDesc(status);
        List<GetListCarResponse> responses = new ArrayList<>();
        for (Car car:cars
             ) {
            GetListCarResponse response = new GetListCarResponse(car.getId(), car.getStatus(), car.getDailyPrice(), car.getPlate());
            responses.add(response);
        }
        return responses;
    }

    @Override
    public List<GetListCarResponse> search() {
        return carRepository.search();
    }

    @Override
    public List<GetListCarResponse> searchRentCar(int status) {
        return carRepository.searchRentCar(status);
    }

    @Override
    public GetCarResponse getById(int id) {
        Car  car = carRepository.findById(id).orElseThrow();
        GetCarResponse carResponse = new GetCarResponse();
        carResponse.setDailyPrice(car.getDailyPrice());
        carResponse.setStatus(car.getStatus());
        carResponse.setPlate(car.getPlate());

        return carResponse;
    }

    @Override
    public void add(AddCarRequest request) {
        if(carRepository.existsByPlate(request.getPlate())){
            throw new RuntimeException("Aynı Plaka numarası girilemez.");
        }
        Car car = new Car();
        Model model = new Model();
        model.setId(request.getModelId());
        car.setModel(model);
        car.setDailyPrice(request.getDailyPrice());
        car.setPlate(request.getPlate());
        car.setStatus(request.getStatus());
        carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest request) {
        Car car = new Car();
        car.setId(request.getId());
        carRepository.findById(car.getId()).orElseThrow();
        Model model = new Model();
        model.setId(request.getModelId());
        car.setModel(model);
        car.setDailyPrice(request.getDailyPrice());
        car.setPlate(request.getPlate());
        car.setStatus(request.getStatus());
        carRepository.save(car);
    }

    @Override
    public void delete(int id) {
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);

    }
}
