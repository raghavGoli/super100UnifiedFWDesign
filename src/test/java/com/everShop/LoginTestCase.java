package com.everShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestCase {
    WebDriver wd;
    String productNameToClick ="Nike zoom fly";
    String fullName ="Venkata";
    String telephone ="8148765432";
    String address ="Test Address";
    String city ="Hyderabad";
    String country= "United States";
    String province ="Alabama";
    String postalCode ="810001";
    String shippingMethodName ="Standard Delivery";
    String paymentMethodType ="Cash On Delivery";



    @BeforeTest
    public void initiateChromeAndNavigateToURL(){
        wd =new ChromeDriver();
    }

    @Test
    public void verifyLoginEverShop() {
        LoginPOM loginObj = new LoginPOM(wd);
        loginObj.get()
                .loginToEverShopSite("gvenkataraghavendra@gmail.com", "Sdetjob@12")
                .isKidsMenuDisplayed().clickProductName(productNameToClick)
                .selectItemSizeOrColor("XL")
                .selectItemSizeOrColor("Black")
                .fillItemQty("2")
                .clickAddToCartBtn()
                .clickViewCartButton()
                .clickCheckoutBtn()
                .setFullName(fullName)
                .setTelephoneNum(telephone)
                .setAddress(address)
                .setCity(city)
                .selectCountry(country)
                .selectProvince(province)
                .setPostalCode(postalCode)
                .clickShippingMethod(shippingMethodName)
                .clickContinueToPayment()
                .selectPaymentMethod(paymentMethodType)
                .clickPlaceOrder();

    }


}
