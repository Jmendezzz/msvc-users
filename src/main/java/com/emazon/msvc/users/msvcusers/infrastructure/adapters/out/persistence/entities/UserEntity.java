package com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String firstName;
  @Column(nullable = false)
  private String lastName;
  @Column(unique = true, nullable = false)
  private String identityNumber;
  @Column(unique = true, nullable = false)
  private String phoneNumber;
  @Column(nullable = false)
  private LocalDate birthDate;
  @Column(unique = true, nullable = false)
  private String email;
  @Column(nullable = false)
  private String password;
  @ManyToOne
  private RoleEntity role;

}
