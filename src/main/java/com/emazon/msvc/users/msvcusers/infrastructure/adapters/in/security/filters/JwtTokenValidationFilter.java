package com.emazon.msvc.users.msvcusers.infrastructure.adapters.in.security.filters;

import com.emazon.msvc.users.msvcusers.domain.ports.out.security.TokenService;
import com.emazon.msvc.users.msvcusers.infrastructure.utils.constants.JwtTokenConstant;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.apache.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtTokenValidationFilter extends OncePerRequestFilter {
  private final TokenService tokenService;
  private final UserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String token = request.getHeader(HttpHeaders.AUTHORIZATION);

    if (token != null && token.startsWith(JwtTokenConstant.TOKEN_PREFIX)) {
      token = token.substring(7);

      if (!tokenService.validateToken(token))  return;

      String username = tokenService.getUsernameFromToken(token);

      UserDetails userDetails = userDetailsService.loadUserByUsername(username);

      UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
              userDetails,
              null,
              userDetails.getAuthorities()
      );

      SecurityContext context = SecurityContextHolder.getContext();
      context.setAuthentication(authentication);
    }

    filterChain.doFilter(request, response);

  }
}
