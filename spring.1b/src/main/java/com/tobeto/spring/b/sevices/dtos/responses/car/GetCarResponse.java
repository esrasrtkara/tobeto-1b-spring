package com.tobeto.spring.b.sevices.dtos.responses.car;

import lombok.Data;

@Data
public class GetCarResponse {
    private int status;
    private int dailyPrice;
    private String plate;
}
