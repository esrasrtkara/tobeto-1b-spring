package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Customer;
import com.tobeto.spring.b.sevices.dtos.responses.customer.GetListCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findByName(String name);
    List<Customer> findByNameOrSurname(String name , String lastname );

    boolean existsByPhone(String phone);

    @Query("SELECT new com.tobeto.spring.b.sevices.dtos.responses.customer" +
            ".GetListCustomerResponse(c.id,c.name,c.surname,c.address,c.phone) " +
            "FROM Customer c WHERE c.address=:address")
    List<GetListCustomerResponse> searchAddress(String address);

    @Query("SELECT new com.tobeto.spring.b.sevices.dtos.responses.customer" +
            ".GetListCustomerResponse(c.id,c.name,c.surname,c.address,c.phone) " +
            " FROM Customer c Where c.name=:name and c.surname=:surname")
    List<GetListCustomerResponse> searchNameAndSurname(String name,String surname);
}
