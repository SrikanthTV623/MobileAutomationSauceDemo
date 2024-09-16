package com.automation.steps;

import com.automation.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

public class ProductsSteps {

    ProductsPage productsPage = new ProductsPage();

    @Then("verify user is on products page")
    public void verifyUserIsOnProductsPage() {
        Assert.assertTrue(productsPage.productsPageIsDisplayed());
    }

    @And("print all product items names")
    public void printAllProductItemsNames() {
        Set<String> prodNames = new HashSet<>(productsPage.printAllProductsNames());
        productsPage.performScroll();
        prodNames.addAll(productsPage.printAllProductsNames());
        //prodNames.forEach(System.out::println);
        for (String name : prodNames) {
            System.out.println(name);
        }
        productsPage.performScroll();
    }

    @When("user add first item to cart in product page")
    public void userAddFirstItemToCartInProductPage() {
        productsPage.clickOnFirstItemInProductPage();
        productsPage.performScrollInBasePage();
        productsPage.performScrollInBasePage();
        productsPage.clickOnAddToCartButton();
    }

    @Then("verify item is added to cart")
    public void verifyItemIsAddedToCart() {
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed());
        Assert.assertEquals("1",productsPage.cartCountDisplayed());
    }

    @When("user applies filter on the products list {string}")
    public void userAppliesFilterOnTheProductsList(String value) {
        productsPage.applyFilterOnProductsList(value);
    }


    @Then("verify the prices are sorted")
    public void verifyThePricesAreSorted() throws InterruptedException {
        productsPage.getAllProductNames().forEach((k,v)-> System.out.println(k+" "+v));
    }

    @And("user clicks on cart and checkout")
    public void userClicksOnCartAndCheckout() {
        productsPage.clickOnCartButton();
    }


    @And("user click on add to cart button using double tap")
    public void userClickOnAddToCartButtonUsingDoubleTap() {
        productsPage.clickOnFirstItemInProductPage();
        productsPage.performScrollInBasePage();
        productsPage.performScrollInBasePage();
        productsPage.performDoubleTapOnAddToCartButton();
    }

    @Then("verify add to cart button is not changed")
    public void verifyAddToCartButtonIsNotChanged() {
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed());
    }
}
