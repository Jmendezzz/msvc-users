package com.emazon.msvc.users.msvcusers.infrastructure.adapters.in.security.config;

import com.emazon.msvc.users.msvcusers.domain.ports.out.security.TokenService;
import com.emazon.msvc.users.msvcusers.infrastructure.adapters.in.security.filters.JwtAuthenticationEntryPoint;
import com.emazon.msvc.users.msvcusers.infrastructure.adapters.in.security.filters.JwtTokenValidationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
  private final TokenService tokenService;
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
            .exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(new JwtAuthenticationEntryPoint()))
            .addFilterBefore(new JwtTokenValidationFilter(tokenService), BasicAuthenticationFilter.class)
            .build();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

}
