package com.motocart.gatekeeper_microservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private int userId;
    private String userName;
}