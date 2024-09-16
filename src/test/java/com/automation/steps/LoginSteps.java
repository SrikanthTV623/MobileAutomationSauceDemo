package com.automation.steps;

import com.automation.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user opens application")
    public void user_opens_application() {

    }

    @Then("verify user is on login page")
    public void verify_user_is_on_login_page() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @When("user will scroll the login page")
    public void user_will_scroll_the_login_page() {
        loginPage.performScroll();
    }

    @When("print the login details")
    public void print_the_login_details() {
        loginPage.printListOfUsernamesAndPasswords();
    }

    @When("user enter valid login credentials")
    public void userEnterValidLoginCredentials() {
        loginPage.doLogin();
    }

}
