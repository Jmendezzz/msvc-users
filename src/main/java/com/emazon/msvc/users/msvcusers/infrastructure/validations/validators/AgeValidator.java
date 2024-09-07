package com.emazon.msvc.users.msvcusers.infrastructure.validations.validators;

import com.emazon.msvc.users.msvcusers.infrastructure.validations.annotations.MinAge;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class AgeValidator implements ConstraintValidator<MinAge, LocalDate> {
  private int minAge;

  @Override
  public void initialize(MinAge minAge) {
    this.minAge = minAge.value();
  }

  @Override
  public boolean isValid(LocalDate birthDate, ConstraintValidatorContext context) {
    if (birthDate == null) return true;

    return Period.between(birthDate, LocalDate.now()).getYears() >= minAge;
  }

}
