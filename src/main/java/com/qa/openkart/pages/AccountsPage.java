package com.qa.openkart.pages;

import com.qa.openkart.utils.Constants;
import com.qa.openkart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {

    private WebDriver driver;
    public ElementUtil elementUtil;

    private By search = By.name("search");
    private By logoutLink = By.linkText("Logout");
    private By accountHeaderLists = By.cssSelector("div#content h2");

    public AccountsPage(WebDriver driver){
        this.driver =driver;
        elementUtil = new ElementUtil(driver);
    }

    public String accPageTitle(){
        return elementUtil.waitForTitleToBe(Constants.DEFAULT_TIME_OUT, Constants.ACC_PAGE_TITLE);
    }

    public boolean isLogoutLinkExist(){
        return elementUtil.doIsDiplayed(logoutLink);
    }

    public boolean isSearchFieldExist(){
        return elementUtil.doIsDiplayed(search);
    }

    public List<String> getAccountHeaderLists() {
        List<String> secHeaderList = new ArrayList<>();

        try {
            List<WebElement> sectionListsElements = elementUtil.getElementsVisible(accountHeaderLists);
            for (WebElement e : sectionListsElements) {
                secHeaderList.add(e.getText());
            }
        } catch (StaleElementReferenceException e) {
            // Retry once in case of stale element
            List<WebElement> sectionListsElements = elementUtil.getElementsVisible(accountHeaderLists);
            for (WebElement e1 : sectionListsElements) {
                secHeaderList.add(e1.getText());
            }
        }

        return secHeaderList;
    }
}
