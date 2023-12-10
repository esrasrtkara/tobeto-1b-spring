package com.tobeto.spring.b.sevices.dtos.responses.model;

import com.tobeto.spring.b.sevices.dtos.responses.brand.GetBrandListResponce;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class GetListResponse {
    private int id;
    private String name;
    private int year;
    private String color;
    private GetBrandListResponce brand;
}
