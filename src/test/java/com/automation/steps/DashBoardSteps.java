package com.automation.steps;

import com.automation.pages.DashBoardPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashBoardSteps {

    DashBoardPage dashBoardPage = new DashBoardPage();

    @When("user clicks on hamburger menu  and select the web view")
    public void userClicksOnHamburgerMenuAndSelectTheWebView() {
        dashBoardPage.openWebViewScreen();
    }

    @And("user enters the website {string}")
    public void userEntersTheWebsite(String webSite) {
        dashBoardPage.enterWebSite(ConfigReader.getConfigValue(webSite));
    }

    @Then("print the contexts of application")
    public void printTheContentsOfApplication() {
        dashBoardPage.printTheContexts();
    }

    @When("user clicks on hamburger menu")
    public void userClicksOnHamburgerMenu() {
        dashBoardPage.clickOnHamBurgerMenu();
    }

    @And("click on logout link")
    public void clickOnLogoutLink() {
        dashBoardPage.clickOnLogoutButton();
    }
}
