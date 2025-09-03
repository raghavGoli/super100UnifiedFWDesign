package com.everShop.web;

import com.everShop.web.components.HeaderPOM;
import com.everShop.web.utility.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePOM {

    protected WebDriver wd;

    protected HeaderPOM headerPOM;

    public BasePOM(WebDriver wd) {
        this.wd = wd;
        headerPOM = new HeaderPOM(wd);
    }

    public BasePOM get(String resourcePath) {
        String baseUrl = PropertyReader.getProperty("url");
        wd.get(baseUrl.concat(resourcePath));
        wd.manage().window().maximize();
        return this;
    }

    public HeaderPOM getHeader() {
        return headerPOM;
    }

    public void waitForElementToBeClickable(By locator) {
        WebDriverWait webDriverWait = new WebDriverWait(wd, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }


}
