package com.example.ValidationExample.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "user name should not be Empty")
    private String name;
    @NotNull(message = "user address should not be null")
    private String address;
    @Email(message = "this is not correct email format")
    private String email;
    @Min(value = 23,message = "age is less then 23")
    @Max(value =65,message="age is more then 65")
    public int age;
    @NotNull
    private double salary;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public User(Integer id, String name, String address, String email, int age, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;
        this.salary = salary;
    }

    public User() {
    }
}
