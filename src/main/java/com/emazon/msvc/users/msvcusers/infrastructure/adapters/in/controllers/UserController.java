package com.emazon.msvc.users.msvcusers.infrastructure.adapters.in.controllers;

import com.emazon.msvc.users.msvcusers.application.dtos.user.CreateUserDtoRequest;
import com.emazon.msvc.users.msvcusers.application.dtos.user.UserResponseDto;
import com.emazon.msvc.users.msvcusers.application.handlers.UserHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
  private final UserHandler userHandler;

  @PostMapping("/create/warehouse-assistant")
  public ResponseEntity<UserResponseDto> createWarehouseAssistant(@Valid @RequestBody CreateUserDtoRequest userDto){
    return new ResponseEntity<>(userHandler.createWarehouseAssistant(userDto), HttpStatus.CREATED);
  }

}