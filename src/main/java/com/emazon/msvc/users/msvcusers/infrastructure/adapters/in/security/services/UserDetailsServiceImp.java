package com.emazon.msvc.users.msvcusers.infrastructure.adapters.in.security.services;

import com.emazon.msvc.users.msvcusers.domain.models.User;
import com.emazon.msvc.users.msvcusers.domain.ports.out.repositories.UserRepository;
import com.emazon.msvc.users.msvcusers.infrastructure.adapters.in.security.models.CustomUserDetails;
import com.emazon.msvc.users.msvcusers.infrastructure.utils.constants.SecurityConstant;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {
  private final UserRepository userRepository;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findUserByEmail(username);
    return user
            .map(CustomUserDetails::new)
            .orElseThrow(() -> new UsernameNotFoundException(SecurityConstant.USER_NOT_FOUND_EXCEPTION_MESSAGE));
  }
}
