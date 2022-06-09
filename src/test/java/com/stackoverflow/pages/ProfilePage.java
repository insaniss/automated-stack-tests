package com.stackoverflow.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ProfilePage {
  public SelenideElement profileBtn = $x("//a[contains(@class, 'm0')]");
  public SelenideElement activityBtn = $x("//a[text()='Activity']");
  public SelenideElement settingsBtn = $x("//a[text()='Settings']");
  public SelenideElement editBtn = $x("//a[@data-shortcut='E']");
  public SelenideElement locationInput = $x("//*[@id='location']");
  public SelenideElement titleInput = $x("//*[@id='Title']");
  public SelenideElement saveBtn = $x("//button[normalize-space(text()) = 'Save changes just for this community']");

  public ProfilePage open() {
    Selenide.open("/");

    profileBtn.click();
    return this;
  }

  public ProfilePage activity() {
    activityBtn.click();
    return this;
  }

  public ProfilePage clickLink(String id) {
    $x(format("//a[normalize-space(text())='%s']", id)).click();
    return this;
  }

  public ProfilePage settings() {
    settingsBtn.click();
    return this;
  }

  public ProfilePage edit() {
    editBtn.click();
    return this;
  }

  public ProfilePage typeLocation(String newLocation) {
    locationInput.val(newLocation);
    locationInput.pressEnter();
    return this;
  }

  public ProfilePage typeTitle(String title) {
    titleInput.val(title);
    return this;
  }

  public ProfilePage clickSave() {
    saveBtn.click();
    return this;
  }

  public SelenideElement titleWithText(String title) {
    return $x(format("//h2[contains(text(),'%s')]", title));
  }

  public SelenideElement withLocation(String location) {
    return $x(format("//div[normalize-space(text())='%s']", location));
  }

  public SelenideElement withTitle(String title) {
    return $x(format("//div[text()='%s']", title));
  }
}
