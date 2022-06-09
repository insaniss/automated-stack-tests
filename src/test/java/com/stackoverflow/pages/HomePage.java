package com.stackoverflow.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class HomePage {
  public SelenideElement usersNav = $x("//*[@id='nav-users']");
  public SelenideElement usersInput = $x("//*[@id='userfilter']");
  public SelenideElement emptyState = $x("//div[contains(@class, 'p32')]");

  public HomePage open() {
    Selenide.open("/home");
    return this;
  }

  public HomePage clickNav(String id) {
    $x(format("//*[@id='%s']", id)).click();
    return this;
  }

  public HomePage users() {
    usersNav.click();
    return this;
  }

  public HomePage typeUsername(String username) {
    usersInput.val(username);
    return this;
  }

  public SelenideElement titleWithText(String title) {
    return $x(format("//h1[contains(text(),'%s')]", title));
  }

  public SelenideElement emptyState() {
    return emptyState;
  }
}
