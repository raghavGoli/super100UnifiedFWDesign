package com.everShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePagePOM extends BasePOM {

    public homePagePOM(WebDriver wd){
        super(wd);
    }
    private By kidsButton =By.xpath("//a[@href='/kids']");

    public boolean isKidsMenuDisplayed(){
        waitForElementToBeClickable(kidsButton);
        return wd.findElement(kidsButton).isDisplayed();
    }
}
