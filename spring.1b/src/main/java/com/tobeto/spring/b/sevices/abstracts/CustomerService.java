package com.tobeto.spring.b.sevices.abstracts;

import com.tobeto.spring.b.entities.Customer;
import com.tobeto.spring.b.sevices.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.b.sevices.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.sevices.dtos.responses.customer.GetCustomerResponse;
import com.tobeto.spring.b.sevices.dtos.responses.customer.GetListCustomerResponse;

import java.util.List;

public interface CustomerService {
    List<GetListCustomerResponse> getAll();
    GetCustomerResponse getById(int id);
    void add(AddCustomerRequest request);
    void update(UpdateCustomerRequest request);
    void delete(int id);
    List<GetListCustomerResponse> getByName(String name);
    List<GetListCustomerResponse> getByNameOrSurname(String name, String surname);
    List<GetListCustomerResponse> searchAddress(String address);
    List<GetListCustomerResponse> searchNameAndSurname(String name, String surname);
}
