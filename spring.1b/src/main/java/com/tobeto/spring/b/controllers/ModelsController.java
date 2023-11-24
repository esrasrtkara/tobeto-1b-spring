package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.sevices.abstracts.ModelService;
import com.tobeto.spring.b.sevices.dtos.requests.model.AddModelRequest;
import com.tobeto.spring.b.sevices.dtos.requests.model.UpdateModelRequest;
import com.tobeto.spring.b.sevices.dtos.responses.model.GetListModelResponse;
import com.tobeto.spring.b.sevices.dtos.responses.model.GetModelResponse;
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
    private final ModelService modelService;

    @GetMapping
    public List<GetListModelResponse> getAll(){
        return modelService.getAll();
    }
    @GetMapping("{id}")
    public GetModelResponse getById(@PathVariable int id){
        return modelService.getById(id);
    }
    @PostMapping
    public  void add(@RequestBody AddModelRequest addModelRequest){
        modelService.add(addModelRequest);
    }
    @PutMapping
    public void update(@RequestBody UpdateModelRequest updateModelRequest){
        modelService.update(updateModelRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        modelService.delete(id);
    }
}
