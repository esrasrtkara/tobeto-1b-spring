package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.dtos.responses.brand.GetBrandListResponce;
import com.tobeto.spring.b.dtos.responses.brand.GetBrandResponce;
import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<GetBrandListResponce> getAll(){
        List<Brand> brands = brandRepository.findAll();
        List<GetBrandListResponce> getBrandListResponces = new ArrayList<GetBrandListResponce>();
        for (Brand brand: brands
             ) {
            GetBrandListResponce getBrandListResponce =new GetBrandListResponce();

            getBrandListResponce.setId(brand.getId());
            getBrandListResponce.setName(brand.getName());

            getBrandListResponces.add(getBrandListResponce);
        }

        return getBrandListResponces;
    }

    @GetMapping("{id}")
    public GetBrandResponce getById(@PathVariable int id){
        //Optional<T> => ilgili filtreden bir veri dönmeyebilir.
        Brand brand = brandRepository.findById(id).orElseThrow();
        GetBrandResponce getBrandResponce = new GetBrandResponce();
        getBrandResponce.setName(brand.getName());
        return getBrandResponce;
    }
    @PostMapping
    public void add(@RequestBody AddBrandRequest addBrandRequest){
        Brand brand = new Brand();
        brand.setName(addBrandRequest.getName());

        brandRepository.save(brand);
    }
    @PutMapping
    public  void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        Brand brand = new Brand();
        brand.setId(updateBrandRequest.getId());
        brandRepository.findById(brand.getId()).orElseThrow();
        brand.setName(updateBrandRequest.getName());
        brandRepository.save(brand);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){

        Brand  brandToDelete = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToDelete);

    }

}
//her istek için bir Request ve Response olmalıdır
//AddBrandResponce AddBrandRequest
