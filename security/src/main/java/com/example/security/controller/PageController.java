package com.example.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Iterator;

@RestController
public class PageController {

    @GetMapping("/")
    public String mainPage() {

        // 유저 이름 가져오기
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // 유저 권한 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        GrantedAuthority role = iterator.next();

        return "main page : " + username + " / " + role;
    }

    @GetMapping("/user")
    public String userPage() {
        return "user page";
    }

    @GetMapping("/manager")
    public String managerPage() {
        return "manager page";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin page";
    }
}
