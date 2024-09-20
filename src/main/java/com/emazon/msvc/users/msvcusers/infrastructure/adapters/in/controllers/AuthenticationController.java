package com.emazon.msvc.users.msvcusers.infrastructure.adapters.in.controllers;

import com.emazon.msvc.users.msvcusers.application.dtos.authentication.AuthenticationResponseDto;
import com.emazon.msvc.users.msvcusers.application.dtos.authentication.LoginRequestDto;
import com.emazon.msvc.users.msvcusers.application.dtos.authentication.SignUpRequestDto;
import com.emazon.msvc.users.msvcusers.application.handlers.AuthenticationHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@AllArgsConstructor
public class AuthenticationController {
  private final AuthenticationHandler authenticationHandler;
  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponseDto> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
    return ResponseEntity.ok(authenticationHandler.login(loginRequestDto));
  }

  @PostMapping("/signup")
  public ResponseEntity<AuthenticationResponseDto> signUp(@Valid @RequestBody SignUpRequestDto signUpRequestDto) {
    return ResponseEntity.ok(authenticationHandler.signUp(signUpRequestDto));
  }
}
