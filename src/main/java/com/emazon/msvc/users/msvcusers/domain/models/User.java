package com.emazon.msvc.users.msvcusers.domain.models;

import com.emazon.msvc.users.msvcusers.domain.exceptions.InvalidInputException;
import com.emazon.msvc.users.msvcusers.domain.utils.InputValidation;

import java.time.LocalDate;
import java.time.Period;

import static com.emazon.msvc.users.msvcusers.domain.utils.constants.UserExceptionCode.*;
import static com.emazon.msvc.users.msvcusers.domain.utils.constants.UserExceptionMessage.*;
import static com.emazon.msvc.users.msvcusers.domain.utils.constants.UserValidationConstant.MIN_AGE;

public class User {
  private Long id;
  private String firstName;
  private String lastName;
  private String identityNumber;
  private String phoneNumber;
  private LocalDate birthDate;
  private String email;
  private String password;
  private Role role;

  public User(Long id, String firstName, String lastName, String identityNumber, String phoneNumber, LocalDate birthDate, String email, String password, Role role) {
    setId(id);
    setFirstName(firstName);
    setLastName(lastName);
    setIdentityNumber(identityNumber);
    setPhoneNumber(phoneNumber);
    setBirthDate(birthDate);
    setEmail(email);
    setPassword(password);
    setRole(role);
  }

  public User() {
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    if(InputValidation.isNullOrEmpty(firstName)){
      throw new InvalidInputException(USER_FIRST_NAME_NULL_OR_EMPTY, USER_FIRST_NAME_NULL_OR_EMPTY_CODE);
    }
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    if(InputValidation.isNullOrEmpty(lastName)){
      throw new InvalidInputException(USER_LAST_NAME_NULL_OR_EMPTY, USER_LAST_NAME_NULL_OR_EMPTY_CODE);
    }
    this.lastName = lastName;
  }
  public void setIdentityNumber(String identityNumber) {
    if(InputValidation.isNullOrEmpty(identityNumber)){
      throw new InvalidInputException(USER_IDENTITY_NUMBER_NULL_OR_EMPTY, USER_IDENTITY_NUMBER_NULL_OR_EMPTY_CODE);
    }
    this.identityNumber = identityNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    if(InputValidation.isNullOrEmpty(phoneNumber)){
      throw new InvalidInputException(USER_PHONE_NUMBER_NULL_OR_EMPTY, USER_PHONE_NUMBER_NULL_OR_EMPTY_CODE);
    }
    if(!InputValidation.isPhoneNumberValid(phoneNumber)){
      throw new InvalidInputException(USER_PHONE_NUMBER_INVALID, USER_PHONE_NUMBER_INVALID_CODE);
    }
    this.phoneNumber = phoneNumber;
  }

  public void setBirthDate(LocalDate birthDate) {
    if(InputValidation.isNull(birthDate)){
      throw new InvalidInputException(USER_BIRTH_DATE_NULL, USER_BIRTH_DATE_NULL_CODE);
    }
    if(Period.between(birthDate, LocalDate.now()).getYears() < MIN_AGE){
      throw new InvalidInputException(USER_MIN_AGE, USER_MIN_AGE_CODE);
    }
    this.birthDate = birthDate;
  }

  public void setEmail(String email) {
    if(InputValidation.isNullOrEmpty(email)){
      throw new InvalidInputException(USER_EMAIL_NULL_OR_EMPTY, USER_EMAIL_NULL_OR_EMPTY_CODE);
    }
    if(!InputValidation.isEmailValid(email)){
      throw new InvalidInputException(USER_EMAIL_INVALID_FORMAT, USER_EMAIL_INVALID_FORMAT_CODE);
    }
    this.email = email;
  }

  public void setPassword(String password) {
    if(InputValidation.isNullOrEmpty(password)){
      throw new InvalidInputException(USER_PASSWORD_NULL_OR_EMPTY, USER_PASSWORD_NULL_OR_EMPTY_CODE);
    }
    if(!InputValidation.isPasswordValid(password)){
      throw new InvalidInputException(USER_PASSWORD_INVALID_FORMAT, USER_PASSWORD_INVALID_FORMAT_CODE);
    }
    this.password = password;
  }

  public void setRole(Role role) {
    if(InputValidation.isNull(role)){
      throw new InvalidInputException(USER_ROLE_NULL, USER_ROLE_NULL_CODE);
    }
    this.role = role;
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public Role getRole() {
    return role;
  }

  public String getIdentityNumber() {
    return identityNumber;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }
  public String getPhoneNumber() {
    return phoneNumber;
  }
}
