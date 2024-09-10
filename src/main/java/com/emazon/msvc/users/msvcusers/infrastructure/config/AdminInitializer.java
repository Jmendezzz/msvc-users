package com.emazon.msvc.users.msvcusers.infrastructure.config;

import com.emazon.msvc.users.msvcusers.domain.models.Role;
import com.emazon.msvc.users.msvcusers.domain.models.User;
import com.emazon.msvc.users.msvcusers.domain.ports.out.repositories.RoleRepository;
import com.emazon.msvc.users.msvcusers.domain.ports.out.repositories.UserRepository;
import com.emazon.msvc.users.msvcusers.domain.ports.out.security.PasswordEncoder;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.role.RoleConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.time.LocalDate;

@Configuration
@Order(2)
public class AdminInitializer {
  @Value("${users.admin.firstName}")
  private String adminFirstName;
  @Value("${users.admin.lastName}")
  private String adminLastName;
  @Value("${users.admin.identityNumber}")
  private String adminIdentityNumber;
  @Value("${users.admin.phoneNumber}")
  private String adminPhoneNumber;
  @Value("${users.admin.birthDate}")
  private LocalDate adminBirthDate;
  @Value("${users.admin.email}")
  private String adminEmail;
  @Value("${users.admin.password}")
  private String adminPassword;
  @Bean
  public CommandLineRunner initializeAdmin(
          RoleRepository roleRepository,
          UserRepository userRepository,
          PasswordEncoder passwordEncoder){
    return args ->{
      if(userRepository.findUserByEmail(adminEmail).isEmpty()){
        Role adminRole = roleRepository.findRoleByName(RoleConstant.ROLE_ADMIN).get();
        User admin = new User();
        admin.setFirstName(adminFirstName);
        admin.setLastName(adminLastName);
        admin.setIdentityNumber(adminIdentityNumber);
        admin.setPhoneNumber(adminPhoneNumber);
        admin.setBirthDate(adminBirthDate);
        admin.setEmail(adminEmail);
        admin.setPassword(passwordEncoder.encode(adminPassword));
        admin.setRole(adminRole);

        userRepository.saveUser(admin);
      }
    };

  }
}
