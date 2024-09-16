package com.automation.steps;

import com.automation.pages.CheckOutPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckOutSteps {

    CheckOutPage checkOutPage = new CheckOutPage();

    @Then("verify user is on checkout page")
    public void verifyUserIsOnCheckoutPage() {
        Assert.assertTrue(checkOutPage.checkOutPageIsDisplayed());
    }

    @When("enters information {string} {string} {string} in check out page")
    public void entersInformationInCheckOutPage(String firstName, String lastName, String zipCode) {
        checkOutPage.entersCheckOutInformation(
                ConfigReader.getConfigValue(firstName),
                ConfigReader.getConfigValue(lastName),
                ConfigReader.getConfigValue(zipCode));
    }

    @Then("verify order is placed")
    public void verifyOrderIsPlaced() {
        Assert.assertEquals("CHECKOUT: COMPLETE!",checkOutPage.isCheckOutPageDisplayed());
    }
}
