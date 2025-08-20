package com.everShop;

import com.everShop.dao.input.CheckoutInputDAO;
import com.everShop.dao.input.HomeInputDAO;
import com.everShop.dao.input.LoginInputDAO;
import com.everShop.dao.input.ProductInputDAO;
import com.everShop.dao.output.CartOutputDAO;
import com.everShop.dao.output.CheckoutOutputDAO;
import com.everShop.dao.output.HomeOutputDAO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestCase {
    WebDriver wd;
    LoginInputDAO loginInputDAO;
    String emailId = "gvenkataraghavendra@gmail.com";
    String appPwd = "Sdetjob@12";
    String productNameToClick = "Nike zoom fly";
    String fullName = "Venkata";
    String telephone = "8148765432";
    String address = "Test Address";
    String city = "Hyderabad";
    String country = "United States";
    String province = "Alabama";
    String postalCode = "810001";
    String shippingMethodName = "Standard Delivery";
    String paymentMethodType = "Cash On Delivery";


    @BeforeTest
    public void initiateChromeAndNavigateToURL() {
        wd = new ChromeDriver();
        loginInputDAO = new LoginInputDAO(emailId, appPwd);
    }

    @Test
    public void verifyLoginEverShop() {
        LoginPOM loginObj = new LoginPOM(wd);
        HomeInputDAO homeInputDAO = new HomeInputDAO(productNameToClick);
        ProductInputDAO productInputDAO = new ProductInputDAO("XL", "Black", "2");
        CheckoutInputDAO checkoutInputDAO = new CheckoutInputDAO(fullName, telephone, address, city, country, province, postalCode, shippingMethodName, paymentMethodType);

        loginObj.get()
                .loginToEverShopSite(loginInputDAO)
                .isKidsMenuDisplayed().clickProductName(homeInputDAO)
                .fillProductDetails(productInputDAO)
                .clickAddToCartBtn()
                .clickViewCartButton()
                .clickCheckoutBtn()
                .fillShippingDetails(checkoutInputDAO)
                .clickShippingMethod(checkoutInputDAO.getShippingMethod())
                .clickContinueToPayment()
                .selectPaymentMethod(checkoutInputDAO.getPaymentMethod())
                .clickPlaceOrder();

    }

    @Test
    public void FetchProductDetailsInCartPage() {
        LoginPOM loginObj = new LoginPOM(wd);

        loginObj.get()
                .loginToEverShopSite(loginInputDAO)
                .isKidsMenuDisplayed();
        CartPOM cartPOM = new CartPOM(wd);
        CartOutputDAO cartOutputDAO = cartPOM.get().getCartDataFromUI();
        System.out.println(cartOutputDAO);

    }


    @Test
    public void FetchProductDetailsInHomePage() {
        LoginPOM loginObj = new LoginPOM(wd);
        HomeOutputDAO homeOutputDAO = loginObj.get()
                .loginToEverShopSite(loginInputDAO)
                .isKidsMenuDisplayed().getProductDataFromHomePage();
        System.out.println(homeOutputDAO);

    }


    @Test
    public void FetchProductDetailsFromCheckoutPage() {
        LoginPOM loginObj = new LoginPOM(wd);

        loginObj.get()
                .loginToEverShopSite(loginInputDAO)
                .isKidsMenuDisplayed();

        CheckoutPOM checkoutPOM = new CheckoutPOM(wd);
        CheckoutOutputDAO checkoutOutputDAO = checkoutPOM.get()
                .getCheckoutDataFromUI();
        System.out.println(checkoutOutputDAO);

    }


}
