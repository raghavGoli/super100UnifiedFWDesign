package com.everShop;

import com.everShop.dao.input.builder.ApplicationInputDAOBuilder;
import com.everShop.dao.input.builder.Builder;
import com.everShop.dao.input.components.CheckoutInputDAO;
import com.everShop.dao.input.components.HomeInputDAO;
import com.everShop.dao.input.components.LoginInputDAO;
import com.everShop.dao.input.components.ProductInputDAO;
import com.everShop.dao.input.director.Director;
import com.everShop.dao.input.product.ApplicationInputDAO;
import com.everShop.dao.output.CartOutputDAO;
import com.everShop.dao.output.CheckoutOutputDAO;
import com.everShop.dao.output.HomeOutputDAO;
import com.everShop.dao.output.SuccessOutputDAO;
import com.everShop.utility.PropertyReader;
import com.everShop.verifications.Verifications;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestCase extends BaseTest {

    LoginInputDAO loginInputDAO;


    @Test
    public void testE2EWorkFlow() {
        LoginPOM loginObj = new LoginPOM(wd);


        ApplicationInputDAOBuilder appBuilder = new ApplicationInputDAOBuilder();
        Director.fillDataUsingDefault(appBuilder);
        ApplicationInputDAO applicationInputDAO = appBuilder.build();

        SuccessOutputDAO actualData = loginObj.getPage()
                .loginToEverShopSite(applicationInputDAO.getLoginInputDAO())
                .isKidsMenuDisplayed().clickProductName(applicationInputDAO.getHomeInputDAO())
                .fillProductDetails(applicationInputDAO.getProductInputDAO())
                .clickAddToCartBtn()
                .clickViewCartButton()
                .clickCheckoutBtn()
                .fillShippingDetails(applicationInputDAO.getCheckoutInputDAO())
                .clickShippingMethod(applicationInputDAO.getCheckoutInputDAO().getShippingMethod())
                .clickContinueToPayment()
                .selectPaymentMethod(applicationInputDAO.getCheckoutInputDAO().getPaymentMethod())
                .clickPlaceOrder().getSuccessPageData();


    }

    @Test
    public void fetchProductDetailsInCartPage() {
        LoginPOM loginObj = new LoginPOM(wd);

        ApplicationInputDAOBuilder appBuilder = new ApplicationInputDAOBuilder();
        Director.fillDataUsingDefault(appBuilder);
        ApplicationInputDAO applicationInputDAO = appBuilder.build();

        loginObj.getPage()
                .loginToEverShopSite(applicationInputDAO.getLoginInputDAO())
                .isKidsMenuDisplayed();
        CartPOM cartPOM = new CartPOM(wd);
        CartOutputDAO cartOutputDAO = cartPOM.getPage().getCartDataFromUI();
        System.out.println(cartOutputDAO);

    }


    @Test
    public void fetchProductDetailsInHomePage() {
        LoginPOM loginObj = new LoginPOM(wd);
        ApplicationInputDAOBuilder appBuilder = new ApplicationInputDAOBuilder();
        Director.fillDataUsingDefault(appBuilder);
        ApplicationInputDAO applicationInputDAO = appBuilder.build();


        HomeOutputDAO homeOutputDAO = loginObj.getPage()
                .loginToEverShopSite(loginInputDAO)
                .isKidsMenuDisplayed().getProductDataFromHomePage();
        System.out.println(homeOutputDAO);

    }


    @Test
    public void fetchProductDetailsFromCheckoutPage() {
        LoginPOM loginObj = new LoginPOM(wd);
        ApplicationInputDAOBuilder appBuilder = new ApplicationInputDAOBuilder();
        Director.fillDataUsingDefault(appBuilder);
        ApplicationInputDAO applicationInputDAO = appBuilder.build();

        //LoginInputDAO loginInputDAO = new LoginInputDAO(emailId, appPwd);
        loginObj.getPage()
                .loginToEverShopSite(loginInputDAO)
                .isKidsMenuDisplayed();

        CheckoutPOM checkoutPOM = new CheckoutPOM(wd);
        CheckoutOutputDAO checkoutOutputDAO = checkoutPOM.get()
                .getCheckoutDataFromUI();
        System.out.println(checkoutOutputDAO);

    }

    @Test
    public void fetchProductDetailsFromSuccessPage() {
        LoginPOM loginObj = new LoginPOM(wd);
        ApplicationInputDAOBuilder appBuilder = new ApplicationInputDAOBuilder();
        Director.fillDataUsingDefault(appBuilder);
        ApplicationInputDAO applicationInputDAO = appBuilder.build();
        loginObj.getPage()
                .loginToEverShopSite(loginInputDAO)
                .isKidsMenuDisplayed();

        SuccessPOM successPOM = new SuccessPOM(wd);
        successPOM.getPage("c56d0354-bf7f-4896-9ee5-10fed340f03e")
                .getOrderSummaryDataFromUI();
        System.out.println(successPOM);

    }


}
