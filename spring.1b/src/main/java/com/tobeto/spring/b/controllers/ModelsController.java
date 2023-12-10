package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.sevices.abstracts.ModelService;
import com.tobeto.spring.b.sevices.dtos.requests.model.AddModelRequest;
import com.tobeto.spring.b.sevices.dtos.requests.model.UpdateModelRequest;
import com.tobeto.spring.b.sevices.dtos.responses.model.GetListModelResponse;
import com.tobeto.spring.b.sevices.dtos.responses.model.GetListResponse;
import com.tobeto.spring.b.sevices.dtos.responses.model.GetModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("GetByName")
    public List<GetListModelResponse> getByName(@RequestParam String name){
        return modelService.getByName(name);
    }
    @GetMapping("color")
    public List<GetListModelResponse> getByNameAndColor(@RequestParam String name,@RequestParam String color){
        return modelService.getByNameAndColor(name , color);
    }
    @GetMapping("getAll2")
    public List<GetListResponse> findAll(){
        return modelService.findAll();
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
