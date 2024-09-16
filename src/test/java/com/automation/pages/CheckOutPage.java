package com.automation.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage{

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-First Name\"]")
    WebElement firstNameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Last Name\"]")
    WebElement lastNameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]")
    WebElement zipCodeField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]")
    WebElement continueBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")
    WebElement finishBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"CHECKOUT: COMPLETE!\"]")
    WebElement checkOutComplete;

    @FindBy(xpath = "//android.widget.TextView[@text=\"THANK YOU FOR YOU ORDER\"]")
    WebElement thankYouMessage;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, \"Your order has been dispatched\")]")
    WebElement dispatchMessage;

    public void performScroll() {
        // Scroll Logic
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        scrollOrSwipe(width / 2, height / 2, width / 2, 0);
    }

    public boolean checkOutPageIsDisplayed(){
        return firstNameField.isDisplayed() && lastNameField.isDisplayed() && zipCodeField.isDisplayed();
    }

    public void entersCheckOutInformation(String firstNameTxt,String lastNameTxt,String zipCodeTxt){
        firstNameField.sendKeys(firstNameTxt);
        lastNameField.sendKeys(lastNameTxt);
        zipCodeField.sendKeys(zipCodeTxt);
        performScroll();
        continueBtn.click();
        performScroll();
        finishBtn.click();
    }

    public String isCheckOutPageDisplayed(){
        System.out.println(thankYouMessage.getText());
        System.out.println(dispatchMessage.getText());
        return checkOutComplete.getText();
    }
}
