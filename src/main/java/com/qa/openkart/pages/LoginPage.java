package com.qa.openkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    //1. Locators
    private By emailID = By.id("input-email");
    private By passID = By.id("input-password");
    private By  logInButton = By.xpath("//input[@type='submit']");
    private By forgottenButton = By.linkText("Forgotten Password");


    //2. Constructors
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //3. Action class/methods/Functions

    public  String currentPageTitle(){
        return driver.getTitle();
    }

    public String currentPageURL(){
        return driver.getCurrentUrl();
    }

    public Boolean isForgottenPasswordLinkExist(){
        return driver.findElement(forgottenButton).isEnabled();
    }

    public AccountsPage doLogin(String userName, String password){
        driver.findElement(emailID).sendKeys(userName);
        driver.findElement(passID).sendKeys(password);
        driver.findElement(logInButton).click();
        return new AccountsPage(driver);
    }

}
