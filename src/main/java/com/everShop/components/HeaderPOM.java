package com.everShop.components;

import com.everShop.AboutUsPOM;
import com.everShop.AccountPOM;
import com.everShop.CartPOM;
import com.everShop.HomePOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPOM {

    private WebDriver wd;

    public HeaderPOM(WebDriver wd) {
        this.wd = wd;
    }
    private By shopDropdown = By.xpath("//a[contains(text(),'Shop')]");
    private By aboutUsLink = By.xpath("//a[contains(text(),'About us')]");
    private By appLogoIcon = By.xpath("//a[@class='logo-icon']");
    private By searchIcon = By.xpath("//a[@class='search-icon']");
    private By miniCartIcon = By.xpath("//a[@class='mini-cart-icon']");
    private By accountIcon = By.xpath("//a[contains(@href,'account')]");

    public AboutUsPOM clickAboutUsLink(){
        wd.findElement(aboutUsLink).click();
        return new AboutUsPOM(wd);
    }

    public HomePOM clickAppLogoIcon(){
        wd.findElement(appLogoIcon).click();
        return new HomePOM(wd);
    }
    public CartPOM clickMiniCartIcon(){
        wd.findElement(miniCartIcon).click();
        return new CartPOM(wd);
    }

    public AccountPOM clickAccountPOM(){
        wd.findElement(accountIcon).click();
        return new AccountPOM(wd);
    }


}
