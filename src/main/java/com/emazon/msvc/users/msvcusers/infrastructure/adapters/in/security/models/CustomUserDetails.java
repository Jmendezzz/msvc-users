package com.emazon.msvc.users.msvcusers.infrastructure.adapters.in.security.models;

import com.emazon.msvc.users.msvcusers.domain.models.Role;
import com.emazon.msvc.users.msvcusers.domain.models.User;
import com.emazon.msvc.users.msvcusers.infrastructure.utils.constants.SecurityConstant;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
  private Long id;
  private String email;
  private Collection<? extends GrantedAuthority> authorities;

  public CustomUserDetails(User user) {
    this.id = user.getId();
    this.email = user.getEmail();
    this.authorities = mapRolesToAuthorities(user.getRole());
  }

  private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Role role) {
    return List.of(new SimpleGrantedAuthority(SecurityConstant.ROLE_PREFIX + role.getName()));
  }

  public Long getId() {
    return id;
  }
  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public String getPassword() {
    return null;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }
}
