package com.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class LambdaSelenideGitTest {

    private static final String REPOSITORY = "kudart98/gitTest";
    private static final String ISSUE_NUMBER = "#3";

    @Test
    @Tags({@Tag("classicTest"), @Tag("positive")})
    @DisplayName("Issue search at Git Hub - positive")
    void testIssueSearchGitPositive() {
        parameter("Repository", REPOSITORY);

        step("Open target website", () -> {
            open("https://github.com");
        });

        step("Find repo " + REPOSITORY, () -> {
            $(".header-search-input").setValue(REPOSITORY).submit();
        });

        step("Make sure if Issue" + ISSUE_NUMBER + " is present", () -> {
            $(By.linkText(REPOSITORY)).click();
            $(withText("Issues")).click();
            $(withText(ISSUE_NUMBER)).should(Condition.visible);
        });

    }

    @Test
    @Tags({@Tag("classicTest"), @Tag("negative")})
    @DisplayName("Issue search at Git Hub - negative")
    void issueSearchGitTestShouldFail() {
        step("Open target website", () -> {
            open("https://github.com");
        });

        step("Find repo" + REPOSITORY, () -> {
            $(".header-search-input").setValue(REPOSITORY).submit();
        });

        step("Make sure if Issue" + ISSUE_NUMBER + " is present", () -> {
            $(By.linkText(REPOSITORY)).click();
            $(withText("Issase")).click();
            $(withText(ISSUE_NUMBER)).should(Condition.visible);
        });
    }
}
