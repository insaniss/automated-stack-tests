package com.stackoverflow.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
  public SelenideElement emailInput = $x("//*[@id='email']");
  public SelenideElement passwordInput = $x("//*[@id='password']");
  public SelenideElement submitButton = $x("//*[@id='submit-button']");

  public ElementsCollection errorMessages = $$x("//p[contains(@class, 'js-error-message')]");

  public LoginPage open() {
    Selenide.open("/users/login");
    return this;
  }

  public LoginPage typeEmail(String email) {
    emailInput.val(email);
    return this;
  }

  public LoginPage typePassword(String password) {
    passwordInput.val(password);
    return this;
  }

  public LoginPage clickSubmit() {
    submitButton.click();
    return this;
  }

  public ElementsCollection errorMessages() {
    return errorMessages;
  }
}
