package com.example.base.application.dto;

import lombok.Data;

@Data
public class CustomerUpdateRequest {

    private String name;
    private String gender;
    private Integer age;
    private String identification;
    private String address;
    private String phone;

    private String password;
    private Boolean status;
}
