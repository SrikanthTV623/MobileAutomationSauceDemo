package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebViewSearchPage extends BasePage{

    @FindBy(xpath = "//android.view.View//android.widget.Button[@text='Google Search']//following-sibling::android.view.View/android.widget.EditText")
    WebElement searchBoxField;


}
