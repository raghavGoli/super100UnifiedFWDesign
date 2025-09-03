package com.everShop.web;

import com.everShop.web.dao.input.builder.ApplicationInputDAOBuilder;
import com.everShop.web.dao.input.components.LoginInputDAO;
import com.everShop.web.dao.input.director.Director;
import com.everShop.web.dao.input.product.ApplicationInputDAO;
import com.everShop.web.dao.output.SuccessOutputDAO;
import com.everShop.web.utility.DriverManager;
import com.everShop.web.verifications.Verifications;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTestCase extends BaseTest {

    LoginInputDAO loginInputDAO;


    @Test
    @Description("Test E2E workflow of Demo Ever Shop")
    public void testE2EWorkFlow() {

        WebDriver wd = DriverManager.getSession();
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
                .fillAddressDetails(applicationInputDAO.getCheckoutInputDAO())
                .selectShippingMethod(applicationInputDAO.getCheckoutInputDAO().getShippingMethod())
                .clickContinueToPayment()
                .selectPaymentMethod(applicationInputDAO.getCheckoutInputDAO().getPaymentMethod())
                .clickPlaceOrder().getSuccessPageData();
        System.out.println(actualData);

        Verifications.assertSuccessPage(actualData, applicationInputDAO);


    }

    @Test
    @Description("Test E2E workflow2 of Demo Ever Shop")
    public void testE2EWorkFlow2() {

        WebDriver wd = DriverManager.getSession();
        LoginPOM loginObj = new LoginPOM(wd);
        ApplicationInputDAOBuilder appBuilder = new ApplicationInputDAOBuilder();
        Director.fillDataUsingDefault(appBuilder);
        ApplicationInputDAO applicationInputDAO = appBuilder.build();

       loginObj.getPage()
                .loginToEverShopSite(applicationInputDAO.getLoginInputDAO())
                .isKidsMenuDisplayed().clickProductName(applicationInputDAO.getHomeInputDAO())
                .fillProductDetails(applicationInputDAO.getProductInputDAO())
                .clickAddToCartBtn()
                .clickViewCartButton();



    }



}
