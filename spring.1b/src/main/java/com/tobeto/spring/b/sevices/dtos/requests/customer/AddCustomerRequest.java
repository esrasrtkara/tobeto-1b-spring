package com.tobeto.spring.b.sevices.dtos.requests.customer;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddCustomerRequest {
    @NotBlank(message = "name boş bırakılamaz.")
    private String name;
    @NotBlank(message = "surname boş bırakılamaz.")
    private String surname;
    private  String address;
    private String phone;

}
