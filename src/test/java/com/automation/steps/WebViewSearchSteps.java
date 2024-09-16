package com.automation.steps;

import com.automation.pages.WebViewSearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebViewSearchSteps {

    WebViewSearchPage viewSearchPage = new WebViewSearchPage();

    @When("user enter search keyword {string}")
    public void userEnterSearchKeyword(String arg0) {

    }

    @Then("verify search result is displayed")
    public void verifySearchResultIsDisplayed() {

    }
}
