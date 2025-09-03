package com.everShop.api;

import org.testng.annotations.BeforeSuite;
import com.everShop.web.utility.PropertyReader;
public class BaseAPITest {

    @BeforeSuite
    public void beforeSuite() {
        String envName = System.getProperty("envName");
        PropertyReader.readPropertiesFile(envName);
    }
}
