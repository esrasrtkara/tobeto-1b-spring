package com.tobeto.spring.b.dtos.requests.car;

import lombok.Data;

@Data
public class UpdateCarRequest {
    private int id;
    private int modelId;
    private int status;
    private int dailyPrice;
    private String plate;
}
