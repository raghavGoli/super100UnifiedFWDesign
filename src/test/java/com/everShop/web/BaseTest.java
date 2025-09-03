package com.everShop.web;

import com.everShop.web.utility.DriverManager;
import com.everShop.web.utility.PropertyReader;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    WebDriver wd;


    @BeforeSuite
    public void beforeSuite() {

        String envName = System.getProperty("envName");
        PropertyReader.readPropertiesFile(envName);
    }

    @Step("Initiating Chrome Session")
    @BeforeMethod
    public void preStep() {
        DriverManager.createSession("chrome");

    }

    @Step("Kill Chrome Session")
    @AfterMethod
    public void postStep() {


        DriverManager.removeSession();
    }


}
