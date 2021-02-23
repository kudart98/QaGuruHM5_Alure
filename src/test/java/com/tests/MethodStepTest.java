package com.tests;

import com.baseSteps.BaseSteps;
import org.junit.jupiter.api.Test;

public class MethodStepTest {

    public BaseSteps steps = new BaseSteps();

    private static final String REPOSITORY = "kudart98/gitTest";
    private static final String ISSUE_NUMBER = "#3";

    @Test
    public void testIssueSearch() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepoFormSearch(REPOSITORY);
        steps.openRepositoryIssues();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
