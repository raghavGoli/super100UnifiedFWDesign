package com.everShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePOM {

    WebDriver wd;
    public BasePOM(WebDriver wd) {
        this.wd=wd;
    }

    public void waitForElementToBeClickable(By locator)
    {
        WebDriverWait webDriverWait =new WebDriverWait(wd, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
