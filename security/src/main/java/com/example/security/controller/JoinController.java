package com.example.security.controller;

import com.example.security.dto.JoinDto;
import com.example.security.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public ResponseEntity<?> joinProcess(@RequestBody JoinDto joinDto) {

        boolean isJoin = joinService.joinProcess(joinDto);
        if (!isJoin) {
            return new ResponseEntity<>("이미 존재하는 회원입니다.", HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>("회원 가입 성공", HttpStatus.CREATED);
    }
}
