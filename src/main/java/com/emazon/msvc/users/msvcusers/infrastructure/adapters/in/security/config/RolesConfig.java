package com.emazon.msvc.users.msvcusers.infrastructure.adapters.in.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.emazon.msvc.users.msvcusers.domain.utils.constants.role.RoleConstant.ROLE_ADMIN;

@Configuration
public class RolesConfig {
  @Bean
  public String adminRole() {
    return ROLE_ADMIN;
  }
}
