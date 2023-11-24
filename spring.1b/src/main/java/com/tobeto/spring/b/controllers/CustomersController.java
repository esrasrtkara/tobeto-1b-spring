package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.sevices.abstracts.CustomerService;
import com.tobeto.spring.b.sevices.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.b.sevices.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.sevices.dtos.responses.customer.GetCustomerResponse;
import com.tobeto.spring.b.sevices.dtos.responses.customer.GetListCustomerResponse;
import com.tobeto.spring.b.entities.Customer;
import com.tobeto.spring.b.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
public class CustomersController {

    private final CustomerService customerService;

    @GetMapping
    public List<GetListCustomerResponse> getAll(){
       return customerService.getAll();
    }
    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id){
       return customerService.getById(id);
    }
    @PostMapping
    public void add(@RequestBody AddCustomerRequest customerRequest){
        customerService.add(customerRequest);
    }
    @PutMapping
    public void update(@RequestBody UpdateCustomerRequest customerRequest){
        customerService.update(customerRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        customerService.delete(id);
    }
}
