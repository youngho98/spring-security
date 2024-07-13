package com.example.security.service;

import com.example.security.dto.JoinDto;
import com.example.security.entity.User;
import com.example.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean joinProcess(JoinDto joinDto) {

        // DTO 에서 정보 받아오기
        String username = joinDto.getUsername();
        String password = joinDto.getPassword();
        String role = joinDto.getRole();

        // 존재하는 유저인지 확인
        boolean isExist = userRepository.existsByUsername(username);
        if (isExist) {
            return false;
        }

        // 회원가입 진행
        User user = new User();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setRole("ROLE_" + role);

        userRepository.save(user);

        return true;
    }
}
