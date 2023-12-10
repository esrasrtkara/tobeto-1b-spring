package com.tobeto.spring.b.sevices.abstracts;

import com.tobeto.spring.b.sevices.dtos.requests.model.AddModelRequest;
import com.tobeto.spring.b.sevices.dtos.requests.model.UpdateModelRequest;
import com.tobeto.spring.b.sevices.dtos.responses.model.GetListModelResponse;
import com.tobeto.spring.b.sevices.dtos.responses.model.GetListResponse;
import com.tobeto.spring.b.sevices.dtos.responses.model.GetModelResponse;

import java.util.List;

public interface ModelService {
    List<GetListModelResponse> getAll();
    GetModelResponse getById(int id);
    void add(AddModelRequest request);
    void update(UpdateModelRequest request);
    void delete(int id);
    List<GetListModelResponse> getByName(String name);
    List<GetListResponse> findAll();
    List<GetListModelResponse> getByNameAndColor(String name,String color);
}
