package com.emazon.msvc.users.msvcusers.infrastructure.controllers;

import com.emazon.msvc.users.msvcusers.application.handlers.UserHandler;
import com.emazon.msvc.users.msvcusers.infrastructure.adapters.in.controllers.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)

class UserControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserHandler userHandler;

  void testCreateWarehouseAssistantSuccess() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/users/create/warehouse-assistant")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""
                        {
                          "firstName": "Test",
                          "lastName": "User",
                          "identityNumber": "123456789",
                          "phoneNumber": "+57312288854",
                          "birthDate": "2000-01-01",
                          "email": "test@test.com",
                          "password": "P@ssw0rd!123"
                          }
                          """))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.firstName").value("Test"))
            .andExpect(jsonPath("$.lastName").value("User"));
    }
}
