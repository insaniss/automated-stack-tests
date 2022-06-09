package com.stackoverflow.tests;

import com.stackoverflow.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.*;

@UnauthorizedTests
public class LoginPageTest {
  private final LoginPage page = new LoginPage();

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

  @DisplayName("Test with empty password field")
  @ParameterizedTest(name = "[{index}] email: {0}")
  @ValueSource(strings = {
      "example@mail.ru",
      "another@yan.ru"
  })
  void testWithEmptyPasswordField(String email) {
    page.open().typeEmail(email).clickSubmit();
    // assertion
    page.errorMessages()
        .findBy(text("Password cannot be empty."))
        .shouldBe(exist)
        .shouldBe(visible);
  }

  @DisplayName("Test with empty email field")
  @ParameterizedTest(name = "[{index}] password: {0}")
  @ValueSource(strings = {
      "s8cr8tKey",
      "maestro0x"
  })
  void testWithEmptyEmailField(String password) {
    page.open().typePassword(password).clickSubmit();
    // assertion
    page.errorMessages()
        .findBy(text("Email cannot be empty."))
        .shouldBe(exist)
        .shouldBe(visible);
  }
}
