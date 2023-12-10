package com.tobeto.spring.b.sevices.concretes;

import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.entities.Customer;
import com.tobeto.spring.b.entities.Order;
import com.tobeto.spring.b.repositories.OrderRepository;
import com.tobeto.spring.b.sevices.abstracts.OrderService;
import com.tobeto.spring.b.sevices.dtos.requests.order.AddOrderRequest;
import com.tobeto.spring.b.sevices.dtos.requests.order.UpdateOrderRequest;
import com.tobeto.spring.b.sevices.dtos.responses.order.GetListOrderResponse;
import com.tobeto.spring.b.sevices.dtos.responses.order.GetListResponse;
import com.tobeto.spring.b.sevices.dtos.responses.order.GetOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderManager implements OrderService {
    private final OrderRepository orderRepository;
    @Override
    public List<GetListOrderResponse> getAll() {
        List<Order> orders = orderRepository.findAll();
        List<GetListOrderResponse> orderResponses = new ArrayList<GetListOrderResponse>();
        for (Order order:orders
        ) {
            GetListOrderResponse orderResponse = new GetListOrderResponse();

            orderResponse.setId(order.getId());
            orderResponse.setCustomerId(order.getCustomer().getId());
            orderResponse.setCarId(order.getCar().getId());
            orderResponse.setRetalDate(order.getRentalDate());
            orderResponse.setReturnDate(order.getReturnDate());

            orderResponses.add(orderResponse);

        }

        return orderResponses;
    }

    @Override
    public List<GetListOrderResponse> getByReturnDate(LocalDate date) {
        List<Order> orders = orderRepository.findByReturnDate(date);
        List<GetListOrderResponse> responses = new ArrayList<>();
        for (Order order:orders
             ) {
            GetListOrderResponse response = new GetListOrderResponse(order.getId(),order.getCustomer().getId(),order.getCar().getId(),order.getRentalDate(),order.getReturnDate());
            responses.add(response);

        }
        return responses;
    }

    @Override
    public List<GetListResponse> getByCarId(int carId) {
        return orderRepository.getByCarId(carId);
    }

    @Override
    public GetOrderResponse getById(int id) {
        Order order = orderRepository.findById(id).orElseThrow();
        GetOrderResponse orderResponse = new GetOrderResponse();
        orderResponse.setCustomerId(order.getCustomer().getId());
        orderResponse.setCarId(order.getCar().getId());
        orderResponse.setRetalDate(order.getRentalDate());
        orderResponse.setReturnDate(order.getReturnDate());

        return   orderResponse;
    }

    @Override
    public void add(AddOrderRequest request) {
        if(request.getRetalDate().isAfter(request.getReturnDate())){
            throw new RuntimeException("Geri dönüş tarihi kiralama tarihinden önce olamaz");
        }
        Order order = new Order();
        Customer customer = new Customer();
        Car car = new Car();
        customer.setId(request.getCustomerId());
        car.setId(request.getCarId());
        order.setCustomer(customer);
        order.setCar(car);
        order.setReturnDate(request.getReturnDate());
        order.setRentalDate(request.getRetalDate());
        orderRepository.save(order);

    }

    @Override
    public void update(UpdateOrderRequest request) {
        Order order = new Order();
        Customer customer = new Customer();
        Car car = new Car();
        customer.setId(request.getCustomerId());
        car.setId(request.getCarId());
        order.setId(request.getId());
        orderRepository.findById(order.getId()).orElseThrow();
        order.setCustomer(customer);
        order.setCar(car);
        order.setReturnDate(request.getReturnDate());
        order.setRentalDate(request.getRetalDate());

        orderRepository.save(order);

    }

    @Override
    public void delete(int id) {
        Order orderToDelete = orderRepository.findById(id).orElseThrow();
        orderRepository.delete(orderToDelete);

    }
}
