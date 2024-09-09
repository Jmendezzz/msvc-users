package com.emazon.msvc.users.msvcusers.infrastructure.config;

import com.emazon.msvc.users.msvcusers.domain.models.Role;
import com.emazon.msvc.users.msvcusers.domain.ports.out.repositories.RoleRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import static com.emazon.msvc.users.msvcusers.domain.utils.constants.role.RoleConstant.*;

@Configuration
@Order(1)
public class RoleInitializer {
  @Bean
  public CommandLineRunner initializeRoles(RoleRepository roleRepository){
    return args ->{
      if(roleRepository.findRoleByName(ROLE_ADMIN).isEmpty()){
        roleRepository.saveRole(new Role(null,ROLE_ADMIN, ROLE_ADMIN_DESCRIPTION));
      }
      if(roleRepository.findRoleByName(ROLE_WAREHOUSE_ASSISTANT).isEmpty()){
        roleRepository.saveRole(new Role(null,ROLE_WAREHOUSE_ASSISTANT, ROLE_WAREHOUSE_ASSISTANT_DESCRIPTION));
      }
      if(roleRepository.findRoleByName(ROLE_CUSTOMER).isEmpty()){
        roleRepository.saveRole(new Role(null,ROLE_CUSTOMER, ROLE_CUSTOMER_DESCRIPTION));
      }
    };
  }
}
