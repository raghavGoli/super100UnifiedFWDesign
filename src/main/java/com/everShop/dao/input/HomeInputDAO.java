package com.everShop.dao.input;

public class HomeInputDAO {

    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public HomeInputDAO(String productName) {
        this.productName = productName;
    }
}
