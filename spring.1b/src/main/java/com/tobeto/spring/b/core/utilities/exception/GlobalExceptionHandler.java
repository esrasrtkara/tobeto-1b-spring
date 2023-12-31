package com.tobeto.spring.b.core.utilities.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String > handleValidationMethod(MethodArgumentNotValidException exception){
        Map<String,String> errors = new HashMap<>();

        for (FieldError error: exception.getBindingResult().getFieldErrors()
             ) {
                errors.put(error.getField(),error.getDefaultMessage());
        }

       // return "Validasyon Hatası";
        return errors;
    }
    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleRunTimeError(RuntimeException exception){
        return exception.getMessage();
    }



    //Know Types
    //UnknowTypes

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String hadleUnknownErrors(){
        return "Bilinmedik hata";
    }
}
