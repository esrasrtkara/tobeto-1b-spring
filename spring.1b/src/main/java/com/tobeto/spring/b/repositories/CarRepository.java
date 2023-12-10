package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.sevices.dtos.responses.car.GetListCarResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {
    List<Car> findByPlate(String plate);
    List<Car> findByStatusOrderByDailyPriceDesc(int status);
    boolean existsByPlate(String plate);

    @Query("SELECT new com.tobeto.spring.b.sevices.dtos.responses.car.GetListCarResponse(c.id,c.status,c.dailyPrice,c.plate)FROM Car c")
    List<GetListCarResponse> search();
    @Query("SELECT new com.tobeto.spring.b.sevices.dtos.responses.car.GetListCarResponse(c.id,c.status,c.dailyPrice,c.plate) FROM Car c WHERE c.status =:status")
    List<GetListCarResponse> searchRentCar(int status);
}
