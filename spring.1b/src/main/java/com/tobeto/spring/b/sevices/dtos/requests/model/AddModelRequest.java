package com.tobeto.spring.b.sevices.dtos.requests.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddModelRequest {
    @NotBlank(message = "model ismi boş bırakılamaz.")
    @Size(min = 3,max = 30,message = "model ismi 3 ile 30 karakter olarak girilebilir.")
    private String name;
    private int year;
    private String color;
    private String fuel;
    private String gear;
    private String caseType;
    private int brandId;
}
