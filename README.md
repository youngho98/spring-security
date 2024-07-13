# Spring Security와 JWT를 이용한 로그인 구현

## Config

### SecurityConfig.java
- AuthenticationManager Bean 등록
- BCryptPasswordEncoder Bean 등록
- SecurityFilterChain 기본 설정
  - CORS 설정
  - disable 설정 (csrf, form 로그인, http basic 인증)
  - 경로별 인가 작업
  - 필터 등록
    - JwtFilter
    - LoginFilter
  - 세션 설정 (stateless)
- 권한 계층 설정

### CorsMvcConfig.java
- CORS 설정

<br>

## Jwt

### JwtUtil.java
- JWT 토큰 생성, 관리

### JwtFilter.java
- JWT 검증을 통해 로그인 여부 확인을 위한 필터

### LoginFilter.java
- 로그인 처리를 위한 필터

<br>

## Controller

### PageController.java
- 메인 페이지
- USER, MANAGER, ADMIN 권한별 접근가능 페이지

### JoinController.java
- 회원가입 기능

<br>

## Service

### CustomUserDetailsService.java
- Spring Security에서 사용자의 정보를 가져옴

### JoinService.java
- 회원가입 기능

<br>

## Dto

### CustomUserDetails.java
- Spring Security에서 사용자의 정보를 담음

### JoinDto.java
- 회원가입 DTO
  - role : `ADMIN`, `MANAGER`, `USER` 중에 선택

<br>

## Entity

### User.java
- user 엔티티
  - id (PK, 자동으로 부여)
  - username (unique)
  - password
  - role

<br>

## Repository

### UserRepository.java
- Spring Data JPA로 만들어진 repository

<br>

## Resources

### application.yml
- DB 연결 설정
- Hibernate DDL 설정
- JWT 암호화 키 설정