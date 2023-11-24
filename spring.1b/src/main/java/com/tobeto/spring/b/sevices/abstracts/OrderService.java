package com.tobeto.spring.b.sevices.abstracts;

import com.tobeto.spring.b.sevices.dtos.requests.order.AddOrderRequest;
import com.tobeto.spring.b.sevices.dtos.requests.order.UpdateOrderRequest;
import com.tobeto.spring.b.sevices.dtos.responses.order.GetListOrderResponse;
import com.tobeto.spring.b.sevices.dtos.responses.order.GetOrderResponse;

import java.util.List;

public interface OrderService {
    List<GetListOrderResponse> getAll();
    GetOrderResponse getById(int id);
    void add(AddOrderRequest request);
    void update(UpdateOrderRequest request);
    void delete(int id);
}
