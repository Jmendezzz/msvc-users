package com.emazon.msvc.users.msvcusers.infrastructure.adapters.in.security.filters;

import com.emazon.msvc.users.msvcusers.domain.utils.constants.token.TokenExceptionMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;


public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2) throws IOException {
    response.setStatus(HttpStatus.UNAUTHORIZED.value());
    response.setContentType("application/json");
    String jsonResponseBody = "{\"error\": \"" + TokenExceptionMessage.INVALID_TOKEN_MESSAGE + "\"}";
    response.getOutputStream().println(jsonResponseBody);
  }
}
