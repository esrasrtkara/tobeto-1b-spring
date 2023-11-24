package com.tobeto.spring.b.sevices.abstracts;

import com.tobeto.spring.b.sevices.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.sevices.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.sevices.dtos.responses.brand.GetBrandListResponce;
import com.tobeto.spring.b.sevices.dtos.responses.brand.GetBrandResponce;

import java.util.List;

public interface BrandService {
    void add(AddBrandRequest request);
    GetBrandResponce getById(int id);
    List<GetBrandListResponce> getAll();
    void update(UpdateBrandRequest request);
    void delete(int id);
}
