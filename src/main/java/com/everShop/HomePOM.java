package com.everShop;

import com.everShop.utility.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePOM extends BasePOM {

    public HomePOM(WebDriver wd){
        super(wd);
    }
    private By kidsButton =By.xpath("//a[@href='/kids']");
    private String productNameLink ="//div[@class='listing-tem']/div[contains(@class,'product-name')]/a/span[text()='$$$']";

    public By getProductLinkLocator(String productName){
       String updatedProductName= productNameLink.replace("$$$",productName);
       return By.xpath(updatedProductName);
    }


    public HomePOM get() {
        String resourcePath = "/";
        String baseURL = "https://demo.evershop.io";
        String newURL =  baseURL.concat(resourcePath);
        get(newURL);
        return this;
    }

    public HomePOM isKidsMenuDisplayed(){
        waitForElementToBeClickable(kidsButton);
         wd.findElement(kidsButton).isDisplayed();
         return this;
    }

    public ProductPOM clickProductName(String productName){
        wd.findElement(getProductLinkLocator(productName)).click();
        return new ProductPOM(wd);
    }
}
