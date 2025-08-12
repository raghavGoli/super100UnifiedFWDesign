package com.everShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestCase {
    WebDriver wd;
    String productNameToClick ="Nike zoom fly";

    @BeforeTest
    public void initiateChromeAndNavigateToURL(){
        wd =new ChromeDriver();
    }

    @Test
    public void verifyLoginEverShop() {
        LoginPOM loginObj = new LoginPOM(wd);
        loginObj.get()
                .loginToEverShopSite("venkata.rg1988@gmail.com", "Sdetjob@12")
                .isKidsMenuDisplayed().clickProductName(productNameToClick)
                .selectItemSizeOrColor("XL")
                .selectItemSizeOrColor("Black")
                .fillItemQty("2")
                .clickAddToCartBtn()
                .clickViewCartButton();

    }


}
