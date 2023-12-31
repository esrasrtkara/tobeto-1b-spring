package com.tobeto.spring.b.sevices.dtos.responses.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListOrderResponse {
    private int id;
    private int customerId;
    private int carId;
    private LocalDate retalDate;
    private LocalDate returnDate;
}
