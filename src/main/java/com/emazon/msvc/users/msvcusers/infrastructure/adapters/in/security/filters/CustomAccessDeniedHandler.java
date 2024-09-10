package com.emazon.msvc.users.msvcusers.infrastructure.adapters.in.security.filters;

import com.emazon.msvc.users.msvcusers.domain.utils.constants.token.TokenExceptionMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {
  @Override
  public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
    response.setStatus(HttpStatus.FORBIDDEN.value());
    response.setContentType("application/json");
    String jsonResponseBody = "{\"error\": \"" + TokenExceptionMessage.ACCESS_DENIED_TOKEN_MESSAGE + "\"}";
    response.getOutputStream().println(jsonResponseBody);
  }
}
