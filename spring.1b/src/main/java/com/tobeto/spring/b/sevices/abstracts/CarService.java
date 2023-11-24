package com.tobeto.spring.b.sevices.abstracts;

import com.tobeto.spring.b.sevices.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.b.sevices.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.b.sevices.dtos.responses.car.GetCarResponse;
import com.tobeto.spring.b.sevices.dtos.responses.car.GetListCarResponse;

import java.util.List;

public interface CarService {
    List<GetListCarResponse> getAll();
    GetCarResponse getById(int id);
    void add(AddCarRequest request);
    void update (UpdateCarRequest request);
    void delete(int id);
}
