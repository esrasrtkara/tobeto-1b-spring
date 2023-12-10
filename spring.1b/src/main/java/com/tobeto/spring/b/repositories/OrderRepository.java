package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Order;
import com.tobeto.spring.b.sevices.dtos.responses.order.GetListOrderResponse;
import com.tobeto.spring.b.sevices.dtos.responses.order.GetListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findByReturnDate(LocalDate date);

    @Query("SELECT new com.tobeto.spring.b.sevices.dtos.responses.order.GetListResponse(" +
            "o.id, o.rentalDate, o.returnDate, " +
            "new com.tobeto.spring.b.sevices.dtos.responses.car.GetListCarResponse(c.id, c.status, c.dailyPrice, c.plate)) " +
            "FROM Order o INNER JOIN o.car c WHERE c.id = :carId")
    List<GetListResponse> getByCarId(int carId);


}
