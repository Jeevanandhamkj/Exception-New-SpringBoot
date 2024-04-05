package com.example.ValidationExample.Advice;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionHandle {
    //BindingResult object to capture and handle validation errors.
    //getFieldErrors() is a method provided by the BindingResult interface in Spring MVC.
    // This method is used to retrieve field-specific errors that occurred during the validation process.
    //getBindingResult() is to provide access to the result of the
    // data binding and validation that occurred during the processing of a form submission or request.

  @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String>ExceptionHandling(MethodArgumentNotValidException exception){
      Map<String,String>errorMap=new HashMap<>();
      exception.getBindingResult().getFieldErrors().forEach(m->{
          errorMap.put(m.getField(),m.getDefaultMessage());
      });
      return errorMap;
    }
    @ExceptionHandler(UserAlreadyExistsException.class)
  public Map<String ,String>exceptionrecover(UserAlreadyExistsException exception){
    Map<String,String>errorMap=new HashMap<>();
    errorMap.put("error","User already exists");
    errorMap.put("message","create new ");
    return errorMap;
    }
    @ExceptionHandler(NoSuchElementException.class)
  public Map<String,String>ex(NoSuchElementException exception){
    Map<String,String>errors=new HashMap<>();
    errors.put("error","UserNotFoundException");
    errors.put("message","find another");
    return errors;
    }


}
