package com.baseSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class BaseSteps {
    private static final String BASE_URL = "https://github.com/";

    @Step("Open main page")
    public void openMainPage() {
        open(BASE_URL);
    }

    @Step("Search for repository")
    public void searchForRepository(final String repository) {
        $(".header-search-input").setValue(repository).submit();
    }

    @Step("Go to {repository} from search")
    public void goToRepoFormSearch(final String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Open Issues")
    public void openRepositoryIssues() {
        $(withText("Issues")).click();
    }

    @Step("Make sure if Issue + {number} is present")
    public void shouldSeeIssueWithNumber(final String number) {
        $(withText(number)).shouldBe(Condition.visible);
    }

}