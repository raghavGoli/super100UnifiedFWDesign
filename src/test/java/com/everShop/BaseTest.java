package com.everShop;

import com.everShop.utility.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver wd;


    @BeforeSuite
    public void beforeSuite() {

        String envName = System.getProperty("envName");
        PropertyReader.readPropertiesFile(envName);
    }

    @BeforeTest
    public void initChromeSession() {
        wd = new ChromeDriver();

    }

    @AfterTest(enabled = false)
    public void killChromeSession() {
        wd.quit();
    }


}
