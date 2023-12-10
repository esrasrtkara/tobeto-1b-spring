package com.tobeto.spring.b.sevices.dtos.responses.car;

import com.tobeto.spring.b.entities.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCarResponse {
    private int id;
    private int status;
    private int dailyPrice;
    private String plate;

}
