package com.tobeto.spring.b.sevices.concretes;

import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.repositories.BrandRepository;
import com.tobeto.spring.b.sevices.abstracts.BrandService;
import com.tobeto.spring.b.sevices.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.sevices.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.sevices.dtos.responses.brand.GetBrandListResponce;
import com.tobeto.spring.b.sevices.dtos.responses.brand.GetBrandResponce;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public void add(AddBrandRequest request) {
        if(brandRepository.existsByName(request.getName().trim())){
            throw new RuntimeException("Aynı isimde marka girilemez.");
        }
        Brand brand = new Brand();
        brand.setName(request.getName());

        brandRepository.save(brand);

    }

    @Override
    public GetBrandResponce getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        GetBrandResponce getBrandResponce = new GetBrandResponce();
        getBrandResponce.setName(brand.getName());
        return getBrandResponce;
    }

    @Override
    public List<GetBrandListResponce> getByName(String name) {
       List<Brand> brands = brandRepository.findByNameLike("%"+name+"%");
       List<GetBrandListResponce> responces = new ArrayList<>();
        for (Brand brand:brands
             ) {
            responces.add(new GetBrandListResponce(brand.getName()));

        }
        return responces;
    }

    @Override
    public List<GetBrandListResponce> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetBrandListResponce> getBrandListResponces = new ArrayList<GetBrandListResponce>();
        for (Brand brand: brands
        ) {
            GetBrandListResponce getBrandListResponce =new GetBrandListResponce();

            getBrandListResponce.setName(brand.getName());

            getBrandListResponces.add(getBrandListResponce);
        }

        return getBrandListResponces;
    }

    @Override
    public List<GetBrandListResponce> search(String name) {
        return brandRepository.search3(name);
    }



    @Override
    public void update(UpdateBrandRequest request) {
        Brand brand = new Brand();
        brand.setId(request.getId());
        brandRepository.findById(brand.getId()).orElseThrow();
        brand.setName(request.getName());
        brandRepository.save(brand);

    }

    @Override
    public void delete(int id) {
        Brand  brandToDelete = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToDelete);

    }
}
