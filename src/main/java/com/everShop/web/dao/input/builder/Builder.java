package com.everShop.web.dao.input.builder;

import com.everShop.web.dao.input.components.CheckoutInputDAO;
import com.everShop.web.dao.input.components.HomeInputDAO;
import com.everShop.web.dao.input.components.LoginInputDAO;
import com.everShop.web.dao.input.components.ProductInputDAO;
import com.everShop.web.dao.input.product.ApplicationInputDAO;

public interface Builder {

    Builder setLoginInputDAO(LoginInputDAO loginInputDAO);
    Builder setHomeInputDAO(HomeInputDAO homeInputDAO);
    Builder setProductInputDA0(ProductInputDAO productInputDAO);
    Builder setCheckoutInputDAO(CheckoutInputDAO checkoutInputDAO);

    ApplicationInputDAO build();


}
