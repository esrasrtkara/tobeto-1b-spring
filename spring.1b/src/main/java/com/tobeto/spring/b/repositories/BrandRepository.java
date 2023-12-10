package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.sevices.dtos.responses.brand.GetBrandListResponce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//DATA JPA
//Generic
//Generic türler Referans Type olmak zorundadır
public interface BrandRepository extends JpaRepository<Brand,Integer> {

    //Derived Query Methods
    List<Brand> findByNameLike(String name);

    boolean existsByName(String name);


    //JPA+SQL => JPQL
    //Select* From Brands
    //JPQL => SQL'dekinin tersine tablo ismi değil entity ismi kullanılır.
    @Query("SELECT b FROM Brand b Where b.name=:name")
    List<Brand> search(String name);

    @Query(value = "Select * From brands",nativeQuery = true)
    List<Brand> search2(String name);

    //b => Brand
    //expected => GetBrandListResponse
    @Query("SELECT new com.tobeto.spring.b.sevices.dtos.responses.brand.GetBrandListResponce(b.name) FROM Brand b Where b.name=:name")
    List<GetBrandListResponce> search3(String name);



}
