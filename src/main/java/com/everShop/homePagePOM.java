package com.everShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePagePOM extends BasePOM {

    public homePagePOM(WebDriver wd){
        super(wd);
    }
    private static final By kidsMenu =By.xpath("//a[@href='/kids']");

    public boolean isKidsMenuDisplayed(){
        waitForElementToBeClickable(kidsMenu);
        return wd.findElement(kidsMenu).isDisplayed();
    }
}
