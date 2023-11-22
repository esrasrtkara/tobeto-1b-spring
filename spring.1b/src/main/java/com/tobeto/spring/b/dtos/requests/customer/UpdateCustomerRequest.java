package com.tobeto.spring.b.dtos.requests.customer;

import lombok.Data;

@Data
public class UpdateCustomerRequest {
    private int id;
    private String name;
    private String surname;
    private  String address;
    private String phone;
}
