package com.everShop.web.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

   static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver createSession(String browserName) {
        if(browserName.toLowerCase().equals("chrome")){
            ChromeOptions options = new ChromeOptions();
            WebDriver wd = new ChromeDriver(options);
            driver.set(wd);
        }
        return driver.get();
    }

    public static WebDriver getSession() {
        return driver.get();
    }

    public static void removeSession() {
        driver.get().quit();
        driver.remove();
    }


}
