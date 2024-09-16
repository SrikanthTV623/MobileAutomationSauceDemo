package com.automation.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    WebElement usernameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    WebElement passwordField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    WebElement loginBtn;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, \"accepted usernames\")]//following-sibling::android.view.ViewGroup/android.widget.TextView")
    List<WebElement> listOfUsernames;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, \"the password for all users\")]//following-sibling::android.widget.TextView")
    List<WebElement> listOfPasswords;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, \"the password for all users\")]//following-sibling::android.widget.TextView[@text=\"secret_sauce\"]")
    WebElement secretSauceTxtElementInLogin;

    @FindBy(xpath = "//android.widget.TextView[@text=\"standard_user\"]")
    WebElement clickOnValidLoginOption;

    public boolean isLoginPageDisplayed(){
        return usernameField.isDisplayed() && passwordField.isDisplayed() && loginBtn.isDisplayed();
    }

    public void printListOfUsernamesAndPasswords(){
        for (WebElement name:listOfUsernames){
            System.out.println(name.getText());
        }
        for (WebElement password:listOfPasswords){
            System.out.println(password.getText());
        }
    }

    public void doLogin(){
        clickOnValidLoginOption.click();
        loginBtn.click();
    }

    public void performScroll() {
        // Scroll Logic
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while (!isPresent(secretSauceTxtElementInLogin)) {
            scrollOrSwipe(width / 2, height / 2, width / 2, 0);
        }
    }

}
