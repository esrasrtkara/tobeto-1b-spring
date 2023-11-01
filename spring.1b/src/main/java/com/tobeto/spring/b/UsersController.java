package com.tobeto.spring.b;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UsersController {


    @GetMapping
    public String get(){
        return "Kullanıcı alındı.";
    }

    @PostMapping
    public String post(){
        return "Kullanıcı eklendi.";
    }

    @PutMapping
    public  String put(){
        return  "Kullanıcı güncellendi.";
    }
    @DeleteMapping
    public  String delete(){
        return "Kullanıcı silindi";
    }
}
