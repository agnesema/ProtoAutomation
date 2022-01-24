package com.protoCommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    WebDriver driver;

    public HomePage (WebDriver driver)  {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='col-lg-9']/app-card-list/app-card[1]/div/div[2]/button")
    WebElement addToCartItem1;

    @FindBy(xpath = "//div[@class='col-lg-9']/app-card-list/app-card[2]/div/div[2]/button")
    WebElement addToCartItem2;

    @FindBy(xpath = "//div[@class='col-lg-9']/app-card-list/app-card[3]/div/div[2]/button")
    WebElement addToCartItem3;

    @FindBy(xpath = "//div[@class='col-lg-9']/app-card-list/app-card[4]/div/div[2]/button")
    WebElement addToCartItem4;

    @FindBy(xpath = "//a[@class='nav-link btn btn-primary']")
    WebElement checkoutButton;

    @FindBy(xpath = "//a[@class='nav-link btn btn-primary']")
    WebElement checkoutButtonItems;

    public void addToCart ()  {
        addToCartItem1.click();
        addToCartItem2.click();
        addToCartItem3.click();
        addToCartItem4.click();

    }

    public void navigateToCart ()  {
        checkoutButton.click();
    }


    public boolean successfulAddToBasket () {
        boolean result = false;
        if(driver.getPageSource().contains("Checkout ( 4 )")){
            result = true;
        }
        return result;


    }
}
