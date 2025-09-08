package com.everShop.api.applicationdao;

public class ProductAPIDao {

    private String productName;
    private String sku;

    private String qty;

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return "ProductAPIDao{" +
                "productName='" + productName + '\'' +
                ", sku='" + sku + '\'' +
                ", qty='" + qty + '\'' +
                '}';
    }
}
