package com.automation.pages;

import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;

public class DashBoardPage extends BasePage{

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]")
    WebElement hamBurgerMenu;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-WEBVIEW\"]")
    WebElement webViewOption;

    @FindBy(xpath = "//android.widget.EditText[contains(@content-desc, 'enter a https url')]")
    WebElement websiteTxtField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-GO TO SITE\"]")
    WebElement goToSiteBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGOUT\"]")
    WebElement selectLogoutOption;

    public void openWebViewScreen(){
        hamBurgerMenu.click();
        webViewOption.click();
    }

    public void clickOnHamBurgerMenu(){
        hamBurgerMenu.click();
    }

    public void enterWebSite(String webSiteTxt){
        websiteTxtField.sendKeys(webSiteTxt);
        goToSiteBtn.click();
    }

    public void printTheContexts() {

        SupportsContextSwitching contextSwitching = (SupportsContextSwitching) driver;
        System.out.println(Arrays.toString(contextSwitching.getContextHandles().toArray()));

    }

    public void clickOnLogoutButton(){
        selectLogoutOption.click();
    }
}