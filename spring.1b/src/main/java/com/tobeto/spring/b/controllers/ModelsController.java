package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.entities.Model;
import com.tobeto.spring.b.repositories.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/models")
@AllArgsConstructor
public class ModelsController {
    private final ModelRepository modelRepository;

    @GetMapping
    public List<Model> getAll(){
        return modelRepository.findAll();
    }
    @GetMapping("{id}")
    public Model getById(@PathVariable int id){
        return modelRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public  void add(@RequestBody Model model){
        modelRepository.save(model);
    }
    @PutMapping
    public void update(@RequestBody Model model){
        modelRepository.findById(model.getId()).orElseThrow();
        modelRepository.save(model);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Model modelToDelete = modelRepository.findById(id).orElseThrow();
        modelRepository.delete(modelToDelete);
    }
}
