package com.qa.openkart.tests;

import com.qa.openkart.base.BaseTest;
import com.qa.openkart.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AccountsPageTest extends BaseTest {

    @BeforeClass
    public void accPageSetup() {
        accountsPage = loginPage.doLogin(properties.getProperty("username").trim(), properties.getProperty("password").trim());
    }

    @Test
    public void getAccPageTitleTest() {
        String accountPageTitle = accountsPage.accPageTitle();
        System.out.println("Your account page title is   :  " + accountPageTitle);
        Assert.assertEquals(accountPageTitle, Constants.ACC_PAGE_TITLE);
    }

    @Test
    public void accPageLogoutLinkExistTest() {
        Assert.assertTrue(accountsPage.isLogoutLinkExist());
    }

    @Test
    public void accPageSearchFieldExistTest() {
        Assert.assertTrue(accountsPage.isSearchFieldExist());
    }

    @Test
    public void accPageHeaderListsVerificationTest() {
        List<String> actualAccountHeaderLists = accountsPage.getAccountHeaderLists();
        System.out.println(actualAccountHeaderLists);
        Assert.assertEquals(actualAccountHeaderLists, Constants.expectedHeaderLists);

    }
}