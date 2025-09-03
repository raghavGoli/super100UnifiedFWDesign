package com.everShop.web;

import com.everShop.web.dao.input.components.LoginInputDAO;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPOM extends BasePOM{

    public LoginPOM(WebDriver wd){
        super(wd);
    }

    private By email_input =By.xpath("//input[@placeholder='Email']");
    private By password_input =By.xpath("//input[@placeholder='Password']");
    private By submit_btn =By.xpath("//button[@type='submit']");

    @Step("Open Login Page")
    public LoginPOM getPage() {
        String resourcePath = "/account/login";
        get(resourcePath);
        return this;
    }

    public LoginPOM setEmail(String email){
      wd.findElement(email_input).sendKeys(email);
      return this;
    }

    public LoginPOM setPassword(String password){
        wd.findElement(password_input).sendKeys(password);
        return this;
    }

    public HomePOM clickSubmitButton(){
        wd.findElement(submit_btn).click();
        return new HomePOM(wd);

    }

    @Step("Login to application by providing Email and password")
    public HomePOM loginToEverShopSite(LoginInputDAO loginInputDAO)
    {
        setEmail(loginInputDAO.getEmail());
        setPassword(loginInputDAO.getPassword());
        clickSubmitButton();
        return new HomePOM(wd);
    }


}
