package com.stackoverflow.tests;

import com.stackoverflow.pages.ProfilePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;


@AuthorizedTests
public class ProfilePageTest {
  private final ProfilePage page = new ProfilePage();

  @BeforeEach
  void setUp() {
  }

  @DisplayName("Test activity links")
  @ParameterizedTest(name = "[{index}] linkName: {0}")
  @CsvSource({
      "Summary,Summary",
      "Answers,Answers",
      "Questions,Questions",
      "Tags,Tags",
      "Articles,Articles",
      "Badges,Badge",
      "Bookmarks,Bookmarks",
      "Following,Followed posts",
      "Reputation,Reputation",
      "Responses,Responses",
      "Votes,Votes"
  })
  void testNavLinks(String linkName, String titleName) {
    page.open().activity().clickLink(linkName)
        // assertion
        .titleWithText(titleName)
        .shouldBe(exist)
        .shouldBe(visible);
  }

  @DisplayName("Test location change")
  @ParameterizedTest(name = "[{index}] location: {0}")
  @ValueSource(strings = {
      "Saint Petersburg, Russia"
  })
  void testLocationChange(String location) {
    page.open().settings().edit().typeLocation(location).clickSave()
        // assertion
        .withLocation(location)
        .shouldBe(exist)
        .shouldBe(visible);
  }

  @DisplayName("Test title change")
  @ParameterizedTest(name = "[{index}] title: {0}")
  @ValueSource(strings = {
      "Go"
  })
  void testTitleChange(String title) {
    page.open().settings().edit().typeTitle(title).clickSave()
        // assertion
        .withTitle(title)
        .shouldBe(exist)
        .shouldBe(visible);
  }
}
