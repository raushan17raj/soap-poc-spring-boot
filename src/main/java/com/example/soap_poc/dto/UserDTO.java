package com.example.soap_poc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private Long mobileNo;
}
