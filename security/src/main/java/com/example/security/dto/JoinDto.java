package com.example.security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinDto {

    private String username;
    private String password;
    private String role; // { ADMIN, MANAGER, USER }
}
