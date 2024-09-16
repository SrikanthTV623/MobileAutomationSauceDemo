package com.automation.pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ProductsPage extends BasePage{

    @FindBy(xpath = "//android.widget.TextView[@text=\"PRODUCTS\"]")
    WebElement productTxt;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-PRODUCTS\"]/android.view.ViewGroup//android.view.ViewGroup[@content-desc=\"test-Item\"]//android.widget.TextView[@content-desc=\"test-Item title\"]")
    List<WebElement> listOfProducts;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]")
    WebElement addToCartBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]")
    WebElement removeBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"1\"]")
    WebElement cartCount;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]")
    WebElement filterBtn;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]/android.view.ViewGroup")
    WebElement firstProduct;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]")
    WebElement cartIcon;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]")
    WebElement checkOutBtn;



    public boolean productsPageIsDisplayed(){
        return productTxt.isDisplayed();
    }

    public List<String> printAllProductsNames(){

        List<String> productNames = new ArrayList<>();
        for (WebElement element : listOfProducts) {
            productNames.add(element.getText());
        }
        return productNames;

        //another way of writing the above code
        //return listOfProducts.stream().map(WebElement::getText).toList();
    }

    public void clickOnFirstItemInProductPage(){
        firstProduct.click();
    }

    public void clickOnAddToCartButton(){
        waitForElementToBeVisible(addToCartBtn);
    }

    public void performDoubleTapOnAddToCartButton(){
        // Get the button's coordinates
        //Point buttonLocation = addToCartBtn.getLocation();
        //int x = buttonLocation.getX() + addToCartBtn.getSize().getWidth() / 2;
        //int y = buttonLocation.getY() + addToCartBtn.getSize().getHeight() / 2;

        performDoubleTap(addToCartBtn);
    }

    public boolean isRemoveButtonDisplayed(){
        return removeBtn.isDisplayed();
    }

    public boolean isAddToCartButtonDisplayed(){
        return addToCartBtn.isDisplayed();
    }

    public String cartCountDisplayed(){
        return cartCount.getText();
    }

    public void performScroll() {
        // Scroll Logic
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        scrollOrSwipe(width / 2, height / 2, width / 2, 0);
    }

    public void applyFilterOnProductsList(String value){
        filterBtn.click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+value+"']")).click();
    }

    public void clickOnCartButton(){
        cartIcon.click();
        checkOutBtn.click();
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']/android.view.ViewGroup/android.widget.TextView[2]")
    List<WebElement> productNames;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']/android.view.ViewGroup/android.widget.TextView[3]")
    List<WebElement> productPrices;

    @FindBy(xpath = "//android.widget.TextView[@text='© 2024 Sauce Labs. All Rights Reserved.']")
    WebElement footer;

    public List<String> getProductNames(){
        return productNames.stream().map(WebElement::getText).toList();
    }

    public List<String> getProductPrices(){
        return productPrices.stream().map(WebElement::getText).toList();
    }

    public LinkedHashMap<String,String> getAllProductNames() throws InterruptedException {
        LinkedHashMap<String,String> prods = new LinkedHashMap<>();
        boolean flag = true;
        while (flag) {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            for(int i=0;i<getProductPrices().size();i++){
                prods.put(getProductNames().get(i),getProductPrices().get(i));
            }
            try {
                if (footer.isDisplayed()) flag = false;
            } catch (Exception e) {
                performScroll();
            }
        }
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return prods;
    }
}
