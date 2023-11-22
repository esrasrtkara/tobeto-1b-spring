package com.tobeto.spring.b.dtos.responses.order;

import lombok.Data;

import java.time.LocalDate;
@Data
public class GetListOrderResponse {
    private int id;
    private int customerId;
    private int carId;
    private LocalDate retalDate;
    private LocalDate returnDate;
}
