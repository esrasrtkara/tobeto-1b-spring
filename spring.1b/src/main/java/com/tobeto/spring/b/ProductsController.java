package com.tobeto.spring.b;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
public class ProductsController {


    @GetMapping
    public String get(){
        return "Ürünler alındı.";
    }

    @PostMapping
    public String post(){
        return "Ürün eklendi.";
    }

    @PutMapping
    public  String put(){
        return  "Ürün güncellendi.";
    }
    @DeleteMapping
    public  String delete(){
        return "Ürün silindi";
    }
}