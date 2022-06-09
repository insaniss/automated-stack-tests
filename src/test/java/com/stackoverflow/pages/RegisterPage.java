package com.stackoverflow.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage {
  public SelenideElement displayNameInput = $x("//*[@id='display-name']");
  public SelenideElement emailInput = $x("//*[@id='email']");
  public SelenideElement passwordInput = $x("//*[@id='password']");
  public SelenideElement submitButton = $x("//*[@id='submit-button']");

  public ElementsCollection errorMessages = $$x("//p[contains(@class, 'js-error-message')]");

  public RegisterPage open() {
    Selenide.open("/users/signup");
    return this;
  }

  public RegisterPage typeDisplayName(String displayName) {
    displayNameInput.val(displayName);
    return this;
  }

  public RegisterPage typeEmail(String email) {
    emailInput.val(email);
    return this;
  }

  public RegisterPage typePassword(String password) {
    passwordInput.val(password);
    return this;
  }

  public void clickSubmit() {
    submitButton.click();
  }

  public ElementsCollection errorMessages() {
    return errorMessages;
  }
}
