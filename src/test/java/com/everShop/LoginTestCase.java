package com.everShop;

import com.everShop.dao.input.builder.ApplicationInputDAOBuilder;
import com.everShop.dao.input.components.LoginInputDAO;
import com.everShop.dao.input.director.Director;
import com.everShop.dao.input.product.ApplicationInputDAO;
import com.everShop.dao.output.CartOutputDAO;
import com.everShop.dao.output.HomeOutputDAO;
import com.everShop.dao.output.SuccessOutputDAO;
import com.everShop.verifications.Verifications;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class LoginTestCase extends BaseTest {

    LoginInputDAO loginInputDAO;


    @Test
    @Description("Test E2E workflow of Demo Ever Shop")
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
                .fillAddressDetails(applicationInputDAO.getCheckoutInputDAO())
                .selectShippingMethod(applicationInputDAO.getCheckoutInputDAO().getShippingMethod())
                .clickContinueToPayment()
                .selectPaymentMethod(applicationInputDAO.getCheckoutInputDAO().getPaymentMethod())
                .clickPlaceOrder().getSuccessPageData();
        System.out.println(actualData);

        Verifications.assertSuccessPage(actualData, applicationInputDAO);


    }


}
