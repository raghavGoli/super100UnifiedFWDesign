package com.everShop.dao.input.product;

import com.everShop.dao.input.components.CheckoutInputDAO;
import com.everShop.dao.input.components.HomeInputDAO;
import com.everShop.dao.input.components.LoginInputDAO;
import com.everShop.dao.input.components.ProductInputDAO;

public class ApplicationInputDAO {


    private LoginInputDAO loginInputDAO;
    private HomeInputDAO homeInputDAO;
    private ProductInputDAO productInputDAO;
    private CheckoutInputDAO checkoutInputDAO;

    public ApplicationInputDAO() {
    }

    public void setLoginInputDAO(LoginInputDAO loginInputDAO) {
        this.loginInputDAO = loginInputDAO;
    }

    public void setHomeInputDAO(HomeInputDAO homeInputDAO) {
        this.homeInputDAO = homeInputDAO;
    }

    public void setProductInputDAO(ProductInputDAO productInputDAO) {
        this.productInputDAO = productInputDAO;
    }

    public void setCheckoutInputDAO(CheckoutInputDAO checkoutInputDAO) {
        this.checkoutInputDAO = checkoutInputDAO;
    }

    public ApplicationInputDAO(LoginInputDAO loginInputDAO, HomeInputDAO homeInputDAO, ProductInputDAO productInputDAO, CheckoutInputDAO checkoutInputDAO) {
        this.loginInputDAO = loginInputDAO;
        this.homeInputDAO = homeInputDAO;
        this.productInputDAO = productInputDAO;
        this.checkoutInputDAO = checkoutInputDAO;
    }

    public LoginInputDAO getLoginInputDAO() {
        return loginInputDAO;
    }

    public HomeInputDAO getHomeInputDAO() {
        return homeInputDAO;
    }

    public ProductInputDAO getProductInputDAO() {
        return productInputDAO;
    }

    public CheckoutInputDAO getCheckoutInputDAO() {
        return checkoutInputDAO;
    }

}
