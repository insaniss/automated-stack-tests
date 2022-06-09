package com.stackoverflow.tests;

import com.stackoverflow.pages.RegisterPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.*;

@UnauthorizedTests
public class RegisterPageTest {
  private final RegisterPage page = new RegisterPage();

  @BeforeEach
  void setUp() {
  }

  @DisplayName("Test with empty fields")
  @Test
  void testWithEmptyFields() {
    page.open().clickSubmit();
    // assertion
    page.errorMessages()
        .findBy(text("Email cannot be empty."))
        .shouldBe(exist)
        .shouldBe(visible);
    page.errorMessages()
        .findBy(text("Password cannot be empty."))
        .shouldBe(exist)
        .shouldBe(visible);
  }

  @DisplayName("Test with single display name field")
  @ParameterizedTest(name = "[{index}] displayName: {0}")
  @ValueSource(strings = {
      "monkey",
      "maestro",
      "rambo"
  })
  void testWithSingleDisplayNameField(String displayName) {
    page.open().typeDisplayName(displayName).clickSubmit();
    // assertion
    page.errorMessages()
        .findBy(text("Email cannot be empty."))
        .shouldBe(exist)
        .shouldBe(visible);
    page.errorMessages()
        .findBy(text("Password cannot be empty."))
        .shouldBe(exist)
        .shouldBe(visible);
  }

  @DisplayName("Test with single email field")
  @ParameterizedTest(name = "[{index}] email: {0}")
  @ValueSource(strings = {
      "example@mail.ru",
      "another@yan.ry"
  })
  void testWithSingleEmailField(String email) {
    page.open().typeEmail(email).clickSubmit();
    // assertion
    page.errorMessages()
        .findBy(text("Password cannot be empty."))
        .shouldBe(exist)
        .shouldBe(visible);
  }

  @DisplayName("Test with single password field")
  @ParameterizedTest(name = "[{index}] password: {0}")
  @ValueSource(strings = {
      "s8cr8tKey",
      "maestro0x"
  })
  void testWithSinglePasswordField(String password) {
    page.open().typePassword(password).clickSubmit();
    // assertion
    page.errorMessages()
        .findBy(text("Email cannot be empty."))
        .shouldBe(exist)
        .shouldBe(visible);
  }

  @DisplayName("Test with same display name and email fields")
  @ParameterizedTest(name = "[{index}] displayName: {0}, email: {1}")
  @ValueSource(strings = {
      "maesrto",
      "maestro@bum.bom"
  })
  void testWithEqualDisplayNameAndEmailFields(String value) {
    page.open().typeDisplayName(value).typeEmail(value).clickSubmit();
    // assertion
    page.errorMessages()
        .findBy(text("Name and email address must be different. " +
            "If you don't want to enter a name, just leave it blank."))
        .shouldBe(exist)
        .shouldBe(visible);
  }
}
