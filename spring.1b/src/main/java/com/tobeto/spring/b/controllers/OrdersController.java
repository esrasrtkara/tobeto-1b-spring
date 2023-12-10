package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.sevices.abstracts.OrderService;
import com.tobeto.spring.b.sevices.dtos.requests.order.AddOrderRequest;
import com.tobeto.spring.b.sevices.dtos.requests.order.UpdateOrderRequest;
import com.tobeto.spring.b.sevices.dtos.responses.order.GetListOrderResponse;
import com.tobeto.spring.b.sevices.dtos.responses.order.GetListResponse;
import com.tobeto.spring.b.sevices.dtos.responses.order.GetOrderResponse;
import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.entities.Customer;
import com.tobeto.spring.b.entities.Order;
import com.tobeto.spring.b.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/orders")
@AllArgsConstructor
public class OrdersController {
    private OrderService orderService;

    @GetMapping
    public List<GetListOrderResponse> getAll(){
        return orderService.getAll();
    }
    @GetMapping("{id}")
    public GetOrderResponse getById(@PathVariable int id){
        return orderService.getById(id);
    }
    @GetMapping("Returndate")
    public List<GetListOrderResponse> getByReturnDate(@RequestParam LocalDate date){
        return orderService.getByReturnDate(date);
    }
    @GetMapping("GetByCarId")
    public List<GetListResponse> getByCarId(@RequestParam int carId){
        return orderService.getByCarId(carId);
    }
    @PostMapping
    public void add(@RequestBody AddOrderRequest orderRequest){
        orderService.add(orderRequest);
    }
    @PutMapping
    public void update(@RequestBody UpdateOrderRequest orderRequest){
        orderService.update(orderRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        orderService.delete(id);
    }


}
