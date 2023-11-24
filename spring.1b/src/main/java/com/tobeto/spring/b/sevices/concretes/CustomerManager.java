package com.tobeto.spring.b.sevices.concretes;

import com.tobeto.spring.b.entities.Customer;
import com.tobeto.spring.b.repositories.CustomerRepository;
import com.tobeto.spring.b.sevices.abstracts.CustomerService;
import com.tobeto.spring.b.sevices.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.b.sevices.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.sevices.dtos.responses.customer.GetCustomerResponse;
import com.tobeto.spring.b.sevices.dtos.responses.customer.GetListCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;
    @Override
    public List<GetListCustomerResponse> getAll() {
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

    @Override
    public GetCustomerResponse getById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        GetCustomerResponse customerResponse = new GetCustomerResponse();
        customerResponse.setName(customer.getName());
        customerResponse.setSurname(customer.getSurname());
        customerResponse.setAddress(customer.getAddress());
        customerResponse.setPhone(customer.getPhone());

        return  customerResponse;
    }

    @Override
    public void add(AddCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setSurname(request.getSurname());
        customer.setAddress(request.getAddress());
        customer.setPhone(request.getPhone());
        customerRepository.save(customer);
    }

    @Override
    public void update(UpdateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setId(request.getId());
        customerRepository.findById(customer.getId()).orElseThrow();
        customer.setName(request.getName());
        customer.setSurname(request.getSurname());
        customer.setAddress(request.getAddress());
        customer.setPhone(request.getPhone());
        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }
}
