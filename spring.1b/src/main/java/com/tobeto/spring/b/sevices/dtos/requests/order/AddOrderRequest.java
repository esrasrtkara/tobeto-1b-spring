package com.tobeto.spring.b.sevices.dtos.requests.order;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddOrderRequest {

    private int customerId;
    private int carId;
    @NotNull
    private LocalDate retalDate;
    @NotNull
    private LocalDate returnDate;

}
