package com.proto.tests;

import com.protoCommerce.base.BaseTest;
import com.protoCommerce.pages.CheckoutPage;
import com.protoCommerce.pages.HomePage;
import com.protoCommerce.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestProtoCommerce extends BaseTest {

    LogInPage logInPage;
    HomePage homePage;
    CheckoutPage checkoutPage;


    @Test (priority = 1)
    public void logIn() throws IOException {
        logInPage = new LogInPage(driver);
        logInPage.logIn();
        Assert.assertEquals(logInPage.successfulLogIn(), "ProtoCommerce Home", "Test Failed");
        System.out.println(logInPage.successfulLogIn());
    }

    @Test (priority = 2)
    public void addToCart()  {
        homePage = new HomePage(driver);
        homePage.addToCart();
        Assert.assertTrue(homePage.successfulAddToBasket(), "Test Failed");
        System.out.println(homePage.successfulAddToBasket());
        homePage.navigateToCart();
    }

    @Test (priority = 3)
    public void checkout () throws IOException {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.removeItem();
        checkoutPage.increaseItem();
        checkoutPage.checkOut();
        checkoutPage.purchaseItem();

    }


}
