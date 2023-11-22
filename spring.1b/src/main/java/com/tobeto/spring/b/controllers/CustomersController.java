package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.b.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.dtos.responses.customer.GetCustomerResponse;
import com.tobeto.spring.b.dtos.responses.customer.GetListCustomerResponse;
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

    private final CustomerRepository customerRepository;

    @GetMapping
    public List<GetListCustomerResponse> getAll(){
        List<Customer> customers = customerRepository.findAll();
        List<GetListCustomerResponse> customerResponses = new ArrayList<GetListCustomerResponse>();
        for (Customer customer:customers
             ) {
            GetListCustomerResponse customerResponse = new GetListCustomerResponse();

            customerResponse.setId(customer.getId());
            customerResponse.setName(customer.getName());
            customerResponse.setSurname(customer.getSurname());
            customerResponse.setAddress(customer.getAddress());
            customerResponse.setPhone(customer.getPhone());

            customerResponses.add(customerResponse);

        }
        return customerResponses;
    }
    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id){
        Customer customer = customerRepository.findById(id).orElseThrow();
        GetCustomerResponse customerResponse = new GetCustomerResponse();
        customerResponse.setName(customer.getName());
        customerResponse.setSurname(customer.getSurname());
        customerResponse.setAddress(customer.getAddress());
        customerResponse.setPhone(customer.getPhone());

        return  customerResponse;
    }
    @PostMapping
    public void add(@RequestBody AddCustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setSurname(customerRequest.getSurname());
        customer.setAddress(customerRequest.getAddress());
        customer.setPhone(customerRequest.getPhone());
        customerRepository.save(customer);
    }
    @PutMapping
    public void update(@RequestBody UpdateCustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setId(customerRequest.getId());
        customerRepository.findById(customer.getId()).orElseThrow();
        customer.setName(customerRequest.getName());
        customer.setSurname(customerRequest.getSurname());
        customer.setAddress(customerRequest.getAddress());
        customer.setPhone(customerRequest.getPhone());
        customerRepository.save(customer);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }
}
