package com.tobeto.spring.b.sevices.concretes;

import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.entities.Model;
import com.tobeto.spring.b.repositories.ModelRepository;
import com.tobeto.spring.b.sevices.abstracts.ModelService;
import com.tobeto.spring.b.sevices.dtos.requests.model.AddModelRequest;
import com.tobeto.spring.b.sevices.dtos.requests.model.UpdateModelRequest;
import com.tobeto.spring.b.sevices.dtos.responses.brand.GetBrandListResponce;
import com.tobeto.spring.b.sevices.dtos.responses.model.GetListModelResponse;
import com.tobeto.spring.b.sevices.dtos.responses.model.GetListResponse;
import com.tobeto.spring.b.sevices.dtos.responses.model.GetModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {
    private final ModelRepository modelRepository;
    @Override
    public List<GetListModelResponse> getAll() {
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

    @Override
    public GetModelResponse getById(int id) {
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

    @Override
    public void add(AddModelRequest request) {
        if(request.getYear() < 2008)
        {
            throw new RuntimeException("Yıl 2008' den büyük olmalıdır.");
        }
        Model model = new Model();
        Brand brand = new Brand();
        brand.setId(request.getBrandId());
        model.setBrand(brand);
        model.setName(request.getName());
        model.setYear(request.getYear());
        model.setGear(request.getGear());
        model.setColor(request.getColor());
        model.setCaseType(request.getCaseType());
        model.setFuel(request.getFuel());
        modelRepository.save(model);
    }

    @Override
    public void update(UpdateModelRequest request) {
        Model model = new Model();
        model.setId(request.getId());
        modelRepository.findById(model.getId()).orElseThrow();
        Brand brand = new Brand();
        brand.setId(request.getBrandId());
        model.setBrand(brand);
        model.setName(request.getName());
        model.setYear(request.getYear());
        model.setGear(request.getGear());
        model.setColor(request.getColor());
        model.setCaseType(request.getCaseType());
        model.setFuel(request.getFuel());
        modelRepository.save(model);

    }

    @Override
    public void delete(int id) {
        Model modelToDelete = modelRepository.findById(id).orElseThrow();
        modelRepository.delete(modelToDelete);

    }

    @Override
    public List<GetListModelResponse> getByName(String name) {
        List<Model> models = modelRepository.findByName(name);
        List<GetListModelResponse> responses = new ArrayList<>();
        for (Model model:models
             ) {
            responses.add(new GetListModelResponse(model.getId(), model.getName(), model.getYear(), model.getColor(), model.getFuel(), model.getGear(), model.getCaseType()));
        }
        return responses;
    }

    @Override
    public List<GetListResponse> findAll() {
        return modelRepository.getAll();
    }

    @Override
    public List<GetListModelResponse> getByNameAndColor(String name , String color) {
        List<Model> models = modelRepository.findByNameAndColor(name,color);
        List<GetListModelResponse> responses = new ArrayList<>();
        for (Model model:models
             ) {
            GetListModelResponse response = new GetListModelResponse();
            response.setColor(model.getColor());
            response.setName(model.getName());
            response.setId(model.getId());
            response.setYear(model.getYear());


            responses.add(response);

        }
        return responses;
    }
}
