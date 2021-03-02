package com.tests;

import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PureSelenideGitTest {

    private static final String REPOSITORY = "kudart98/gitTest";
    private static final String ISSUE_NUMBER = "#3";

    @Test
    void testIssueSearchGitPositive() {

        open("https://github.com");
        $(".header-search-input").setValue(REPOSITORY).submit();
        $(By.linkText(REPOSITORY)).click();
        $(withText("Issues")).click();
        $(withText(ISSUE_NUMBER)).shouldBe(Condition.visible);

    }

    @Test
    void issueSearchGitTestShouldFail() {

        open("https://github.com");
        $(".header-search-input").setValue(REPOSITORY).submit();
        $(By.linkText(REPOSITORY)).click();
        $(withText("Issase")).click();
        $(withText(ISSUE_NUMBER)).shouldBe(Condition.visible);

    }

}
