package com.everShop.dao.input.director;

import com.everShop.dao.input.builder.Builder;
import com.everShop.dao.input.components.CheckoutInputDAO;
import com.everShop.dao.input.components.HomeInputDAO;
import com.everShop.dao.input.components.LoginInputDAO;
import com.everShop.dao.input.components.ProductInputDAO;
import com.everShop.dao.input.product.ApplicationInputDAO;

public class Director {

    public static void fillDataUsingAPI(){


    }

    public static void fillDataUsingExcel(){

    }

    public static void fillDataUsingDefault(Builder builder){
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


        LoginInputDAO loginInputDAO = new LoginInputDAO(emailId, appPwd);
        HomeInputDAO homeInputDAO = new HomeInputDAO(productNameToClick);
        ProductInputDAO productInputDAO = new ProductInputDAO("XL", "Black", "2");
        CheckoutInputDAO checkoutInputDAO = new CheckoutInputDAO(fullName, telephone, address, city, country, province, postalCode, shippingMethodName, paymentMethodType);

         builder.setLoginInputDAO(loginInputDAO)
                .setHomeInputDAO(homeInputDAO)
                .setProductInputDA0(productInputDAO)
                .setCheckoutInputDAO(checkoutInputDAO);

    }
}
