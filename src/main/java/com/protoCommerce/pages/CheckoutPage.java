package com.protoCommerce.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static com.protoCommerce.TestDataReader.*;

public class CheckoutPage {

    WebDriver driver;
    String country = getCountry();

    public CheckoutPage (WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//table[@class='table table-hover']/tbody/tr[4]/td[5]/button")
    WebElement removeItemButton;

    @FindBy(xpath = "//table[@class='table table-hover']/tbody/tr[2]/td[2]/input")
    WebElement addNumberOfItems;

    @FindBy(xpath = "//button[@class='btn btn-success']")
    WebElement checkoutButton;

    @FindBy(id = "country")
    WebElement countryField;

    @FindBy(xpath = "//div[@class='suggestions']")
    WebElement countrySuggestions;

    @FindBy(xpath = "//label[contains(text(), 'agree')]")
    WebElement checkBox;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement purchaseButton;


    public void removeItem() {
        removeItemButton.click();
    }

    public void increaseItem (){
        addNumberOfItems.click();
        Actions act = new Actions(driver);
        act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys("2").build().perform();
    }
    public void checkOut() {
        checkoutButton.click();}

    public void purchaseItem (){
        countryField.sendKeys(country);
        WebElement countrySelection = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(countrySuggestions));
        countrySelection.click();
        checkBox.click();
        purchaseButton.click();
    }
}
