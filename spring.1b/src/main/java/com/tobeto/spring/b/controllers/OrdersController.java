package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.dtos.requests.order.AddOrderRequest;
import com.tobeto.spring.b.dtos.requests.order.UpdateOrderRequest;
import com.tobeto.spring.b.dtos.responses.order.GetListOrderResponse;
import com.tobeto.spring.b.dtos.responses.order.GetOrderResponse;
import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.entities.Customer;
import com.tobeto.spring.b.entities.Model;
import com.tobeto.spring.b.entities.Order;
import com.tobeto.spring.b.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/orders")

public class OrdersController {
    private  OrderRepository orderRepository;

    public OrdersController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<GetListOrderResponse> getAll(){
        List<Order> orders = orderRepository.findAll();
        List<GetListOrderResponse> orderResponses = new ArrayList<GetListOrderResponse>();
        for (Order order:orders
             ) {
            GetListOrderResponse orderResponse = new GetListOrderResponse();

            orderResponse.setId(order.getId());
            orderResponse.setCustomerId(order.getCustomer().getId());
            orderResponse.setCarId(order.getCar().getId());
            orderResponse.setRetalDate(order.getRetalDate());
            orderResponse.setReturnDate(order.getReturnDate());

            orderResponses.add(orderResponse);

        }

        return orderResponses;
    }
    @GetMapping("{id}")
    public GetOrderResponse getById(@PathVariable int id){
        Order order = orderRepository.findById(id).orElseThrow();
        GetOrderResponse orderResponse = new GetOrderResponse();
        orderResponse.setCustomerId(order.getCustomer().getId());
        orderResponse.setCarId(order.getCar().getId());
        orderResponse.setRetalDate(order.getRetalDate());
        orderResponse.setReturnDate(order.getReturnDate());

        return   orderResponse;

    }
    @PostMapping
    public void add(@RequestBody AddOrderRequest orderRequest){
        Order order = new Order();
        Customer customer = new Customer();
        Car car = new Car();
        customer.setId(orderRequest.getCustomerId());
        car.setId(orderRequest.getCarId());
        order.setCustomer(customer);
        order.setCar(car);
        order.setReturnDate(orderRequest.getReturnDate());
        order.setRetalDate(orderRequest.getRetalDate());
        orderRepository.save(order);
    }
    @PutMapping
    public void update(@RequestBody UpdateOrderRequest orderRequest){
        Order order = new Order();
        Customer customer = new Customer();
        Car car = new Car();
        customer.setId(orderRequest.getCustomerId());
        car.setId(orderRequest.getCarId());
        order.setId(orderRequest.getId());
        orderRepository.findById(order.getId()).orElseThrow();
        order.setCustomer(customer);
        order.setCar(car);
        order.setReturnDate(orderRequest.getReturnDate());
        order.setRetalDate(orderRequest.getRetalDate());

        orderRepository.save(order);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Order orderToDelete = orderRepository.findById(id).orElseThrow();
        orderRepository.delete(orderToDelete);

    }


}
