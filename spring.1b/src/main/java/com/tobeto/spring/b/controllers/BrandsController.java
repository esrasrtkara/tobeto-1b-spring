package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
    //final bir alanı constructer alan dışında set edilemez.
    private final BrandRepository brandRepository;

    public BrandsController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public List<Brand> getAll(){
        return brandRepository.findAll();
    }

    @GetMapping("{id}")
    public Brand getById(@PathVariable int id){
        //Optional<T> => ilgili filtreden bir veri dönmeyebilir.
        return brandRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Brand brand){

        brandRepository.save(brand);
    }
    @PutMapping
    public  void update(@RequestBody Brand brand){
         brandRepository.findById(brand.getId()).orElseThrow();
         brandRepository.save(brand);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){

        Brand  brandToDelete = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToDelete);

    }

}
