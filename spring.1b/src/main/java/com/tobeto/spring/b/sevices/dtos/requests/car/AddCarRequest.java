package com.tobeto.spring.b.sevices.dtos.requests.car;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class AddCarRequest {
    private int status;
    private int dailyPrice;
    @NotBlank(message = "plate null olamaz.")
    @Size(max =10,message = "plate 10 dan fazla karakter alamaz.")
    private String plate;
    private int modelId;
}
