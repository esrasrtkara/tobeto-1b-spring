package com.tobeto.spring.b.sevices.dtos.requests.car;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class AddCarRequest {
    private int status;
    @Min(value = 600,message = "dailyPrice cannot be less than 600")
    private int dailyPrice;
    private String plate;
    private int modelId;
}
