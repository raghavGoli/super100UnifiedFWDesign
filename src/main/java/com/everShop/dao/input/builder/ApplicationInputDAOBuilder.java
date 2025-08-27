package com.everShop.dao.input.builder;

import com.everShop.dao.input.components.CheckoutInputDAO;
import com.everShop.dao.input.components.HomeInputDAO;
import com.everShop.dao.input.components.LoginInputDAO;
import com.everShop.dao.input.components.ProductInputDAO;
import com.everShop.dao.input.product.ApplicationInputDAO;

public class ApplicationInputDAOBuilder implements Builder{

    private LoginInputDAO loginInputDAO;
    private HomeInputDAO homeInputDAO;
    private ProductInputDAO productInputDAO;
    private CheckoutInputDAO checkoutInputDAO;


    @Override
    public Builder setLoginInputDAO(LoginInputDAO loginInputDAO) {
            this.loginInputDAO =loginInputDAO;
            return this;
    }

    @Override
    public Builder setHomeInputDAO(HomeInputDAO homeInputDAO) {
            this.homeInputDAO=homeInputDAO;
        return this;
    }

    @Override
    public Builder setProductInputDA0(ProductInputDAO productInputDAO) {
            this.productInputDAO=productInputDAO;
        return this;
    }

    @Override
    public Builder setCheckoutInputDAO(CheckoutInputDAO checkoutInputDAO) {
            this.checkoutInputDAO=checkoutInputDAO;
        return this;
    }

    @Override
    public ApplicationInputDAO build() {
        return new ApplicationInputDAO(this.loginInputDAO,this.homeInputDAO,this.productInputDAO,this.checkoutInputDAO);
    }
}
