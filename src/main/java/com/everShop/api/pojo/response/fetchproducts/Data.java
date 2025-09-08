package com.everShop.api.pojo.response.fetchproducts;

import com.everShop.api.pojo.response.createcart.Products;

public class Data {

    private Products products;

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Data{" +
                "products=" + products +
                '}';
    }
}
