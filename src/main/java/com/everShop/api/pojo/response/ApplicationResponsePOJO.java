package com.everShop.api.pojo.response;

import com.everShop.api.pojo.response.createcart.RootCreateCart;
import com.everShop.api.pojo.response.fetchproducts.RootFetchProducts;
import com.everShop.api.pojo.response.login.RootLogin;

public class ApplicationResponsePOJO {

    private RootLogin rootLogin;
    private RootFetchProducts rootFetchProducts;

    private RootCreateCart rootCreateCart;

    public RootCreateCart getRootCreateCart() {
        return rootCreateCart;
    }

    public void setRootCreateCart(RootCreateCart rootCreateCart) {
        this.rootCreateCart = rootCreateCart;
    }

    public RootLogin getRootLogin() {
        return rootLogin;
    }

    public void setRootLogin(RootLogin rootLogin) {
        this.rootLogin = rootLogin;
    }

    public RootFetchProducts getRootFetchProducts() {
        return rootFetchProducts;
    }

    public void setRootFetchProducts(RootFetchProducts rootFetchProducts) {
        this.rootFetchProducts = rootFetchProducts;
    }

    @Override
    public String toString() {
        return "ApplicationResponsePOJO{" +
                "rootLogin=" + rootLogin +
                ", rootFetchProducts=" + rootFetchProducts +
                ", rootCreateCart=" + rootCreateCart +
                '}';
    }
}
