package com.protoCommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static com.protoCommerce.TestDataReader.*;

public class LogInPage {

    WebDriver driver;
    String username = getUsername();
    String password = getPassword();
    String occupation = getOccupation();

    public LogInPage (WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//input[@value='user']/following-sibling::span")
    WebElement userButton;

    @FindBy(id = "okayBtn")
    WebElement okeyButton;

    @FindBy(xpath = "//form[@id='login-form']/div[5]/select")
    WebElement dropDownMenu;

    @FindBy(id = "terms")
    WebElement termsBox;

    @FindBy(id = "signInBtn")
    WebElement signInButton;

    @FindBy (xpath = "//div[@id='navbarResponsive']/parent::div/a")
    WebElement homePageText;


    public void logIn ()  {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        userButton.click();
        WebElement kButton = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(okeyButton));
        kButton.click();
        Select fromMenu = new Select (dropDownMenu);
        fromMenu.selectByVisibleText(occupation);
        termsBox.click();
        signInButton.click();

    }

    public String successfulLogIn ()  {
        WebElement homePage = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(homePageText));
        return homePage.getText();
    }


}
