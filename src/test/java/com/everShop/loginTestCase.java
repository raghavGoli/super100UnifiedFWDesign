package com.everShop;

import everShop.loginPagePOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginTestCase {
    WebDriver wd;

    @BeforeTest
    public void initiateChromeAndNavigateToURL(){
        wd =new ChromeDriver();
        wd.get("https://demo.evershop.io/account/login");
        wd.manage().window().maximize();
        wd.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

    }

    @Test
    public void verifyLoginEverShop(){
       loginPagePOM loginobj = new loginPagePOM(wd);
        loginobj.loginToEverShopSite("venkata.rg1988@gmail.com","Sdetjob@12").isKidsMenuDisplayed();
    }


    @AfterTest
    public void quitChromeSession() {
        wd.quit();
    }
}
