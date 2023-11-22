package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.dtos.requests.model.AddModelRequest;
import com.tobeto.spring.b.dtos.requests.model.UpdateModelRequest;
import com.tobeto.spring.b.dtos.responses.model.GetListModelResponse;
import com.tobeto.spring.b.dtos.responses.model.GetModelResponse;
import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.entities.Model;
import com.tobeto.spring.b.repositories.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/models")
@AllArgsConstructor
public class ModelsController {
    private final ModelRepository modelRepository;

    @GetMapping
    public List<GetListModelResponse> getAll(){
        List<Model> models = modelRepository.findAll();
        List<GetListModelResponse> getListModelResponses = new ArrayList<GetListModelResponse>();
        for (Model model:models
             ) {
            GetListModelResponse getListModelResponse = new GetListModelResponse();

            getListModelResponse.setId(model.getId());
            getListModelResponse.setName(model.getName());
            getListModelResponse.setYear(model.getYear());
            getListModelResponse.setColor(model.getColor());
            getListModelResponse.setFuel(model.getFuel());
            getListModelResponse.setGear(model.getGear());
            getListModelResponse.setCaseType(model.getCaseType());

            getListModelResponses.add(getListModelResponse);

        }
        return getListModelResponses;
    }
    @GetMapping("{id}")
    public GetModelResponse getById(@PathVariable int id){
        Model model = modelRepository.findById(id).orElseThrow();
        GetModelResponse getModelResponse = new GetModelResponse();
        getModelResponse.setYear(model.getYear());
        getModelResponse.setColor(model.getColor());
        getModelResponse.setName(model.getName());
        getModelResponse.setGear(model.getGear());
        getModelResponse.setFuel(model.getFuel());
        getModelResponse.setCaseType(model.getCaseType());

        return getModelResponse;
    }
    @PostMapping
    public  void add(@RequestBody AddModelRequest addModelRequest){
        Model model = new Model();
        Brand brand = new Brand();
        brand.setId(addModelRequest.getBrandId());
        model.setBrand(brand);
        model.setName(addModelRequest.getName());
        model.setYear(addModelRequest.getYear());
        model.setGear(addModelRequest.getGear());
        model.setColor(addModelRequest.getColor());
        model.setCaseType(addModelRequest.getCaseType());
        model.setFuel(addModelRequest.getFuel());
        modelRepository.save(model);
    }
    @PutMapping
    public void update(@RequestBody UpdateModelRequest updateModelRequest){
        Model model = new Model();
        model.setId(updateModelRequest.getId());
        modelRepository.findById(model.getId()).orElseThrow();
        Brand brand = new Brand();
        brand.setId(updateModelRequest.getBrandId());
        model.setBrand(brand);
        model.setName(updateModelRequest.getName());
        model.setYear(updateModelRequest.getYear());
        model.setGear(updateModelRequest.getGear());
        model.setColor(updateModelRequest.getColor());
        model.setCaseType(updateModelRequest.getCaseType());
        model.setFuel(updateModelRequest.getFuel());
        modelRepository.save(model);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Model modelToDelete = modelRepository.findById(id).orElseThrow();
        modelRepository.delete(modelToDelete);
    }
}
