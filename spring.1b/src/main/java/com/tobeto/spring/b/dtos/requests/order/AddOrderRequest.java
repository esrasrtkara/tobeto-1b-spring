package com.tobeto.spring.b.dtos.requests.order;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddOrderRequest {

    private int customerId;
    private int carId;
    private LocalDate retalDate;
    private LocalDate returnDate;

}
