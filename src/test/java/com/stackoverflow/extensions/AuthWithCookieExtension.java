package com.stackoverflow.extensions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.stackoverflow.utilities.CustomConfig;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Configuration.baseUrl;

public class AuthWithCookieExtension implements BeforeAllCallback {
  private final CustomConfig config = CustomConfig.getInstance();

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    open(baseUrl).addCookie(new Cookie("acct", config.getProperty("site.cookie.acct")));
  }

  private AuthWithCookieExtension open(String url) {
    Selenide.open(url); return this;
  }

  private void addCookie(Cookie cookie) {
    WebDriverRunner.getWebDriver().manage().addCookie(cookie);
  }
}
