package com.tobeto.spring.b.sevices.dtos.responses.car;

import lombok.Data;

@Data
public class GetListCarResponse {
    private int id;
    private int status;
    private int dailyPrice;
    private String plate;
}
