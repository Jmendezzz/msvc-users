package com.emazon.msvc.users.msvcusers.domain.models;

import com.emazon.msvc.users.msvcusers.domain.exceptions.InvalidInputException;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.user.UserExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

  private User user;
  @BeforeEach
  void setUp() {
    user = new User();
  }

  // Testing valid first name
  @Test
  void testSetValidFirstName() {
    user.setFirstName("John");
    assertEquals("John", user.getFirstName());
  }

  // Testing empty first name
  @Test
  void testSetFirstNameEmptyShouldThrowException() {
    InvalidInputException exception = assertThrows(InvalidInputException.class, () -> user.setFirstName(""));
    assertEquals(UserExceptionMessage.USER_FIRST_NAME_NULL_OR_EMPTY, exception.getMessage());
  }

  // Testing null first name
  @Test
  void testSetFirstNameNullShouldThrowException() {
    InvalidInputException exception = assertThrows(InvalidInputException.class, () -> user.setFirstName(null));
    assertEquals(UserExceptionMessage.USER_FIRST_NAME_NULL_OR_EMPTY, exception.getMessage());
  }

  // Testing valid last name
  @Test
  void testSetValidLastName() {
    user.setLastName("Doe");
    assertEquals("Doe", user.getLastName());
  }

  // Testing empty last name
  @Test
  void testSetLastNameEmptyShouldThrowException() {
    InvalidInputException exception = assertThrows(InvalidInputException.class, () -> user.setLastName(""));
    assertEquals(UserExceptionMessage.USER_LAST_NAME_NULL_OR_EMPTY, exception.getMessage());
  }

  // Testing valid identity number
  @Test
  void testSetValidIdentityNumber() {
    user.setIdentityNumber("123456789");
    assertEquals("123456789", user.getIdentityNumber());
  }
  @Test
  void testSetIdentityNumberEmptyShouldThrowException() {
    InvalidInputException exception = assertThrows(InvalidInputException.class, () -> user.setIdentityNumber(""));
    assertEquals(UserExceptionMessage.USER_IDENTITY_NUMBER_NULL_OR_EMPTY, exception.getMessage());
  }

  // Testing invalid phone number
  @Test
  void testSetInvalidPhoneNumberShouldThrowException() {
    InvalidInputException exception = assertThrows(InvalidInputException.class, () -> user.setPhoneNumber("123abc"));
    assertEquals(UserExceptionMessage.USER_PHONE_NUMBER_INVALID, exception.getMessage());
  }
  @Test
  void testSetPhoneNumberLengthShouldThrowException() {
    String phoneNumberWith14Digits = "+57300569832512";
    InvalidInputException exception = assertThrows(InvalidInputException.class, () -> user.setPhoneNumber(phoneNumberWith14Digits));
    assertEquals(UserExceptionMessage.USER_PHONE_NUMBER_INVALID, exception.getMessage());
  }
  @Test
  void testSetPhoneNumberEmptyShouldThrowException() {
    InvalidInputException exception = assertThrows(InvalidInputException.class, () -> user.setPhoneNumber(""));
    assertEquals(UserExceptionMessage.USER_PHONE_NUMBER_NULL_OR_EMPTY, exception.getMessage());
  }

  // Testing valid phone number
  @Test
  void testSetValidPhoneNumber() {
    user.setPhoneNumber("+573005698325");
    assertEquals("+573005698325", user.getPhoneNumber());
  }

  // Testing null birth date
  @Test
  void testSetNullBirthDateShouldThrowException() {
    InvalidInputException exception = assertThrows(InvalidInputException.class, () -> user.setBirthDate(null));
    assertEquals(UserExceptionMessage.USER_BIRTH_DATE_NULL, exception.getMessage());
  }

  // Testing underage user
  @Test
  void testSetUnderageUserShouldThrowException() {
    LocalDate birthDate = LocalDate.now().minusYears(15);
    InvalidInputException exception = assertThrows(InvalidInputException.class, () -> user.setBirthDate(birthDate));
    assertEquals(UserExceptionMessage.USER_MIN_AGE, exception.getMessage());
  }

  // Testing valid birth date
  @Test
  void testSetValidBirthDate() {
    LocalDate birthDate = LocalDate.now().minusYears(25);
    user.setBirthDate(birthDate);
    assertEquals(birthDate, user.getBirthDate());
  }

  // Testing valid email
  @Test
  void testSetValidEmail() {
    user.setEmail("test@example.com");
    assertEquals("test@example.com", user.getEmail());
  }

  // Testing invalid email
  @Test
  void testSetInvalidEmailShouldThrowException() {
    InvalidInputException exception = assertThrows(InvalidInputException.class, () -> user.setEmail("invalid@.com"));
    assertEquals(UserExceptionMessage.USER_EMAIL_INVALID_FORMAT, exception.getMessage());
  }
  @Test
  void testSetEmailEmptyShouldThrowException() {
    InvalidInputException exception = assertThrows(InvalidInputException.class, () -> user.setEmail(""));
    assertEquals(UserExceptionMessage.USER_EMAIL_NULL_OR_EMPTY, exception.getMessage());
  }

  // Testing valid password
  @Test
  void testSetValidPassword() {
    user.setPassword("P@ssw0rd123!");
    assertEquals("P@ssw0rd123!", user.getPassword());
  }
  @ParameterizedTest
  @ValueSource(strings = {"weakpassword", "Pass1_", "Pass1234", "PASSWORD123_", "Password_"})
  void testSetInvalidPasswordShouldThrowException(String password) {
    InvalidInputException exception = assertThrows(InvalidInputException.class, () -> user.setPassword(password));
    assertEquals(UserExceptionMessage.USER_PASSWORD_INVALID_FORMAT, exception.getMessage());
  }

  // Testing invalid password (empty)
  @Test
  void testSetPasswordEmptyShouldThrowException() {
    InvalidInputException exception = assertThrows(InvalidInputException.class, () -> user.setPassword(""));
    assertEquals(UserExceptionMessage.USER_PASSWORD_NULL_OR_EMPTY, exception.getMessage());
  }

  // Testing null password
  @Test
  void testSetPasswordNullShouldThrowException() {
    InvalidInputException exception = assertThrows(InvalidInputException.class, () -> user.setPassword(null));
    assertEquals(UserExceptionMessage.USER_PASSWORD_NULL_OR_EMPTY, exception.getMessage());
  }

  // Testing valid role
  @Test
  void testSetValidRole() {
    Role role = new Role();
    role.setName("USER");
    user.setRole(role);
    assertEquals(role, user.getRole());
  }

  // Testing null role
  @Test
  void testSetNullRoleShouldThrowException() {
    InvalidInputException exception = assertThrows(InvalidInputException.class, () -> user.setRole(null));
    assertEquals(UserExceptionMessage.USER_ROLE_NULL, exception.getMessage());
  }

}
