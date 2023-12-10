package com.tobeto.spring.b.sevices.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCustomerResponse {
    private int id;
    private String name;
    private String surname;
    private  String address;
    private String phone;
}
