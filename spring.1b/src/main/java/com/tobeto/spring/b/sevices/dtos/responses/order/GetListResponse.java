package com.tobeto.spring.b.sevices.dtos.responses.order;

import com.tobeto.spring.b.sevices.dtos.responses.car.GetListCarResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListResponse {
    private int id;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private GetListCarResponse car;
}
