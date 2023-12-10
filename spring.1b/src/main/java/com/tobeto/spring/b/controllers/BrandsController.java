package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.sevices.abstracts.BrandService;
import com.tobeto.spring.b.sevices.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.sevices.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.sevices.dtos.responses.brand.GetBrandListResponce;
import com.tobeto.spring.b.sevices.dtos.responses.brand.GetBrandResponce;
import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.repositories.BrandRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/brands")
@AllArgsConstructor
public class BrandsController {
    //final bir alanı constructer alan dışında set edilemez.

    private final BrandService brandService;

    @GetMapping
    public List<GetBrandListResponce> getAll(){
      return  brandService.getAll();
    }
    @GetMapping("{id}")
    public GetBrandResponce getById(@PathVariable int id){
        //Optional<T> => ilgili filtreden bir veri dönmeyebilir.
        return brandService.getById(id);
    }
    @GetMapping("GetByName")
    public List<GetBrandListResponce> getByName(@RequestParam String name){
        return  brandService.getByName(name);
    }

    @GetMapping("search")
    public List<GetBrandListResponce> search(String name){
        return brandService.search(name);
    }
    @PostMapping
    public void add(@RequestBody @Valid AddBrandRequest addBrandRequest){
        brandService.add(addBrandRequest);
    }
    @PutMapping
    public  void update(@RequestBody UpdateBrandRequest updateBrandRequest){
      brandService.update(updateBrandRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
       brandService.delete(id);
    }

}
//her istek için bir Request ve Response olmalıdır
//AddBrandResponce AddBrandRequest
