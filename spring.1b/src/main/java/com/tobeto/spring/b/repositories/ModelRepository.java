package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Model;
import com.tobeto.spring.b.sevices.dtos.responses.model.GetListModelResponse;
import com.tobeto.spring.b.sevices.dtos.responses.model.GetListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model,Integer> {
 //   List<Model> findAllName();
   List<Model>  findByName(String name);
   List<Model>  findByNameAndColor(String name,String color);

   @Query("SELECT new com.tobeto.spring.b.sevices.dtos.responses.model" +
           ".GetListResponse(m.id,m.name,m.year,m.color," +
           "new com.tobeto.spring.b.sevices.dtos.responses.brand.GetBrandListResponce(brand.name)) " +
           "FROM Model m " +
           "INNER JOIN m.brand b ")
   List<GetListResponse> getAll();
   @Query("SELECT m.year FROM Model m ORDER BY m.year DESC")
    List<Integer> getOrderByModelYear();

}
