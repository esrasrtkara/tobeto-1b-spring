package com.tobeto.spring.b.dtos.responses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetModelResponse {
    private String name;
    private int year;
    private String color;
    private String fuel;
    private String gear;
    private String caseType;
}
