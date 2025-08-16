package com.everShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPOM extends BasePOM{

    public CartPOM(WebDriver wd) {
        super(wd);
    }

    private By checkoutBtn = By.xpath("//div[@class='summary']//a");


    public CheckoutPOM clickCheckoutBtn(){
        wd.findElement(checkoutBtn).click();
        return new CheckoutPOM(wd);
    }


}
