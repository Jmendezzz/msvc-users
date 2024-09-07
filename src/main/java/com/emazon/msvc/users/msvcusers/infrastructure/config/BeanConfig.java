package com.emazon.msvc.users.msvcusers.infrastructure.config;

import com.emazon.msvc.users.msvcusers.domain.ports.in.usecases.RoleUseCase;
import com.emazon.msvc.users.msvcusers.domain.ports.in.usecases.UserUseCase;
import com.emazon.msvc.users.msvcusers.domain.ports.out.repositories.RoleRepository;
import com.emazon.msvc.users.msvcusers.domain.ports.out.repositories.UserRepository;
import com.emazon.msvc.users.msvcusers.domain.ports.out.security.PasswordEncoder;
import com.emazon.msvc.users.msvcusers.domain.usecases.RoleUseCaseImp;
import com.emazon.msvc.users.msvcusers.domain.usecases.UserUseCaseImp;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class BeanConfig {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;

  @Bean
  public RoleUseCase roleUseCase(){
    return new RoleUseCaseImp(roleRepository);
  }

  @Bean
  public UserUseCase userUseCase(){
    return new UserUseCaseImp(userRepository,roleUseCase(),passwordEncoder);
  }

}
