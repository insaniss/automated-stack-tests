package com.stackoverflow.tests;

import com.stackoverflow.pages.HomePage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.*;

@AuthorizedTests
public class HomePageTest {
  private final HomePage page = new HomePage();

  @BeforeEach
  void setUp() {
  }

  @Description("Test the navigation open function")
  @ParameterizedTest(name = "[{index}] navName={0}, titleName={1}")
  @CsvSource({
      "nav-questions,All Questions",
      "nav-tags,Tags",
      "nav-users,Users",
      "nav-companies,Companies"
  })
  void testNavOpen(String navName, String pageTitle) {
    page.open().clickNav(navName)
        // assertion
        .titleWithText(pageTitle)
        .shouldBe(exist)
        .shouldBe(visible);
  }

  @Description("Test searching the existing user")
  @ParameterizedTest(name = "[{index}] username={0}")
  @CsvSource({
      "maestro",
      "corecudr",
      "notme",
      "aftersun"
  })
  void testExistingUserSearch(String username) {
    page.open().users().typeUsername(username)
        // assertion
        .emptyState()
        .shouldNotBe(visible);
  }

  @Description("Test for doesn't existing user search")
  @ParameterizedTest(name = "[{index}] username={0}")
  @CsvSource({
      "notfalse",
      "brandgreg"
  })
  void testNotExistingUserSearch(String username) {
    page.open().users().typeUsername(username)
        // assertion
        .emptyState()
        .should(exist)
        .shouldBe(visible);
  }
}
