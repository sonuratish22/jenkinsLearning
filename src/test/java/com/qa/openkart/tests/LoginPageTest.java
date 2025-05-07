package com.qa.openkart.tests;

import com.qa.openkart.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void getCurrentPageUrl(){
        String currentPageURL = loginPage.currentPageURL();
        System.out.println("CurrentPageURL is  " + currentPageURL);
        Assert.assertEquals(currentPageURL, "https://naveenautomationlabs.com/opencart/index.php?route=account/login");
    }
    @Test
    public void getCurrentPageTitle(){
        String actualPageTitle = loginPage.currentPageTitle();
        System.out.println("Actual page title is :   "+ actualPageTitle);
        Assert.assertEquals(actualPageTitle, "Account Login" );
    }

   /* @Test
    public void isForgottenLinkDisplayed(){
        Assert.assertTrue(loginPage.isForgottenPasswordLinkExist());
    }*/



    @Test
    public void doLogin(){
        // loginPage.doLogin("Abc", "Abc");
        accountsPage = loginPage.doLogin(properties.getProperty("username").trim(), properties.getProperty("password").trim());
      //  Assert.assertEquals(accountsPage.getAccountPageTitle(), "My Account");
    }

}
