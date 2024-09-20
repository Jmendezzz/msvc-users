package com.emazon.msvc.users.msvcusers.infrastructure.config;

import com.emazon.msvc.users.msvcusers.domain.ports.in.usecases.AuthenticationUseCase;
import com.emazon.msvc.users.msvcusers.domain.ports.in.usecases.RoleUseCase;
import com.emazon.msvc.users.msvcusers.domain.ports.in.usecases.UserUseCase;
import com.emazon.msvc.users.msvcusers.domain.ports.out.repositories.RoleRepository;
import com.emazon.msvc.users.msvcusers.domain.ports.out.repositories.UserRepository;
import com.emazon.msvc.users.msvcusers.domain.ports.out.security.PasswordEncoder;
import com.emazon.msvc.users.msvcusers.domain.ports.out.security.TokenService;
import com.emazon.msvc.users.msvcusers.domain.usecases.AuthenticationUseCaseImp;
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
  private final TokenService tokenService;

  @Bean
  public RoleUseCase roleUseCase(){
    return new RoleUseCaseImp(roleRepository);
  }

  @Bean
  public UserUseCase userUseCase(){
    return new UserUseCaseImp(userRepository,roleUseCase(),passwordEncoder);
  }

  @Bean
  public AuthenticationUseCase authenticationUseCase(){
    return new AuthenticationUseCaseImp(userUseCase(), userRepository,passwordEncoder,tokenService);
  }

}
