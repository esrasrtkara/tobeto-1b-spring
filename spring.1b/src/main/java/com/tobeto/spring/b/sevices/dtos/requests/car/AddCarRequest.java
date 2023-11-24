package com.tobeto.spring.b.sevices.dtos.requests.car;

import lombok.Data;

@Data
public class AddCarRequest {
    private int status;
    private int dailyPrice;
    private String plate;
    private int modelId;
}
