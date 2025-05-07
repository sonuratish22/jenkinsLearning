package com.qa.openkart.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

    public WebDriver driver;
    public Properties prop;
    public static String highlight;

    public WebDriver initDriver(Properties prop ) {

        highlight = prop.getProperty("highlight");
        String browser = prop.getProperty("browser").trim();
        System.out.println("Browser name is  :  " + browser);
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("IE")) {
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }else {
            System.out.println("Please enter the correct browser name, current browser is  :  "+ browser);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
        return driver;
    }

    public Properties initProp(){

        prop = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("./src/test/resources/config.properties");
            prop.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }
}
