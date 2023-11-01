package com.tobeto.spring.b;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/persons") // Bu controllerın kontrol edeceği alt routeları tanımlamak
public class PersonsController {

    @GetMapping // api/persons
    public String get(){
        return "Get";
    }
    @GetMapping("get2") // api/persons/get2
    public String get2(){
        return "Get 2";
    }
    @PostMapping
    public String post(){
        return "Tobeto";
    }
    @PutMapping
    public  String put(){
        return "put ";
    }

    @DeleteMapping
    public  String delete(){
        return "delete ";
    }
}
