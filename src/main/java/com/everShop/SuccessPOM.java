package com.everShop;

import com.everShop.utility.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPOM extends BasePOM{
    public SuccessPOM(WebDriver wd) {
        super(wd);
    }

    public SuccessPOM getPage(String orderId) {
        String resourcePath = "/checkout/success/"+orderId;
        String baseURL = "https://demo.evershop.io";
        String newURL =  baseURL.concat(resourcePath);
        get(newURL);
        return this;
    }
}
