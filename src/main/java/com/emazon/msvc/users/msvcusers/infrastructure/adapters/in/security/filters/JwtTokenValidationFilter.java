package com.emazon.msvc.users.msvcusers.infrastructure.adapters.in.security.filters;

import com.emazon.msvc.users.msvcusers.domain.ports.out.security.TokenService;
import com.emazon.msvc.users.msvcusers.infrastructure.utils.constants.JwtTokenConstant;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Set;

public class JwtTokenValidationFilter extends OncePerRequestFilter {
  private final TokenService tokenService;

  public JwtTokenValidationFilter(TokenService tokenService) {
    this.tokenService = tokenService;
  }


  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String token = request.getHeader(HttpHeaders.AUTHORIZATION);

    if (token != null && token.startsWith(JwtTokenConstant.TOKEN_PREFIX)) {
      token = token.substring(7);

      if (!tokenService.validateToken(token))  return;

      String username = tokenService.getUsernameFromToken(token);
      String role = tokenService.getRoleFromToken(token);

      Authentication authentication = new UsernamePasswordAuthenticationToken(username,null, Set.of(() -> role));
      SecurityContext context = SecurityContextHolder.getContext();
      context.setAuthentication(authentication);
    }

    filterChain.doFilter(request, response);

  }
}
