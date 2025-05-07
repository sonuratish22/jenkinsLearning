package com.qa.openkart.base;

import com.qa.openkart.DriverFactory.DriverFactory;
import com.qa.openkart.pages.AccountsPage;
import com.qa.openkart.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public DriverFactory driverFactory;
    public LoginPage loginPage;
    public Properties properties;
    public AccountsPage accountsPage;

    @BeforeTest
    public void setUp(){
        driverFactory = new DriverFactory();
        properties = driverFactory.initProp();
        driver= driverFactory.initDriver(properties);
        loginPage = new LoginPage(driver);

    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
