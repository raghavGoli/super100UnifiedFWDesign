package com.everShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginTestCase {
    WebDriver wd;

    @BeforeTest
    public void initiateChromeAndNavigateToURL(){
        wd =new ChromeDriver();

    }

    @Test
    public void verifyLoginEverShop(){
        loginPagePOM loginobj = new loginPagePOM(wd);
        loginobj.get()
                .loginToEverShopSite("venkata.rg1988@gmail.com","Sdetjob@12")
                .isKidsMenuDisplayed();
    }


    @AfterTest
    public void quitChromeSession() {
        wd.quit();
    }
}
