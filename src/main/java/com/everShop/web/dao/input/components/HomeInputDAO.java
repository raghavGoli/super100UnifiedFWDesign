package com.everShop.web.dao.input.components;

import java.util.List;

public class HomeInputDAO {

    private List<String> productNames;

    public HomeInputDAO(List<String> productNames) {
        this.productNames = productNames;
    }

    public List<String> getProductNames() {
        return productNames;
    }


    public void addProductToTheList(String productName) {
        this.productNames.add(productName);

    }

    @Override
    public String toString() {
        return "HomeInputDao{" +
                "productNames=" + productNames +
                '}';
    }
}
