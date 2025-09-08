package com.everShop.api.pojo.request;

public class ProductItemRequestBody {

    private String sku;

    private int qty;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = Integer.parseInt(qty);
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "sku='" + sku + '\'' +
                ", qty='" + qty + '\'' +
                '}';
    }
}
