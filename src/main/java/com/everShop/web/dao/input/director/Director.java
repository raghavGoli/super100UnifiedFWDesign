package com.everShop.web.dao.input.director;

import com.everShop.web.dao.input.builder.Builder;
import com.everShop.web.dao.input.components.CheckoutInputDAO;
import com.everShop.web.dao.input.components.HomeInputDAO;
import com.everShop.web.dao.input.components.LoginInputDAO;
import com.everShop.web.dao.input.components.ProductInputDAO;

import java.util.Arrays;

public class Director {

    public static void fillDataUsingAPI(){


    }

    public static void fillDataUsingExcel(){

    }

    public static void fillDataUsingDefault(Builder builder){
        String emailId = "gvenkataraghavendra@gmail.com";
        String appPwd = "Sdetjob@12";
        String productNameToClick = "Nike court vision low";
        String fullName = "Venkata";
        String telephone = "8148765432";
        String address = "Test Address";
        String city = "Hyderabad";
        String country = "United States";
        String province = "Alabama";
        String postalCode = "810001";
        String shippingMethodName = "Standard Delivery";
        String paymentMethodType = "Cash On Delivery";


        LoginInputDAO loginInputDAO = new LoginInputDAO(emailId, appPwd);
        HomeInputDAO homeInputDAO = new HomeInputDAO(Arrays.asList(productNameToClick));
        ProductInputDAO productInputDAO = new ProductInputDAO("X", "Black", "5",904.00f);
        CheckoutInputDAO checkoutInputDAO = new CheckoutInputDAO(fullName, telephone, address, city, country, province, postalCode, shippingMethodName, paymentMethodType);

         builder.setLoginInputDAO(loginInputDAO)
                .setHomeInputDAO(homeInputDAO)
                .setProductInputDA0(productInputDAO)
                .setCheckoutInputDAO(checkoutInputDAO);

    }
}
