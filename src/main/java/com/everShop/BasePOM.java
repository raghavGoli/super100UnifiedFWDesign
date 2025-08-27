package com.everShop;

import com.everShop.components.HeaderPOM;
import com.everShop.utility.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    /* added this method as unable to clear the quantity input box usign clear*/

    public void clearText(WebElement inputElement) {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("arguments[0].value = '';", inputElement);
    }


    public void setText(WebElement inputElement, String newText) {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript(
                "const input = arguments[0];" +
                        "const nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
                        "nativeSetter.call(input, arguments[1]);" +
                        "input.dispatchEvent(new Event('input', { bubbles: true }));" +
                        "input.dispatchEvent(new Event('change', { bubbles: true }));",
                inputElement, newText
        );
    }


}
