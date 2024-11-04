package com.emazon.msvc.users.msvcusers.infrastructure.adapters.in.controllers;

import com.emazon.msvc.users.msvcusers.application.dtos.pagination.PaginationDto;
import com.emazon.msvc.users.msvcusers.application.dtos.user.CreateUserDtoRequest;
import com.emazon.msvc.users.msvcusers.application.dtos.user.UserResponseDto;
import com.emazon.msvc.users.msvcusers.application.handlers.UserHandler;
import com.emazon.msvc.users.msvcusers.domain.models.Paginated;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
  private final UserHandler userHandler;

  @PostMapping("/create/warehouse-assistant")
  @PreAuthorize("hasRole(@adminRole)")
  public ResponseEntity<UserResponseDto> createWarehouseAssistant(@Valid @RequestBody CreateUserDtoRequest userDto){
    return new ResponseEntity<>(userHandler.createWarehouseAssistant(userDto), HttpStatus.CREATED);
  }

  @GetMapping("/warehouse-assistants")
  @PreAuthorize("hasRole(@adminRole)")
  public ResponseEntity<Paginated<UserResponseDto>> getWarehouseAssistants(@ModelAttribute @Valid PaginationDto paginationDto){
    return new ResponseEntity<>(userHandler.getWarehouseAssistants(paginationDto), HttpStatus.OK);
  }

}
