package com.everShop.dao.input;

public class ProductInputDAO {

    private String productSize;
    private String productColor;
    private String productQty;

    public ProductInputDAO(String productSize, String productColor, String productQty) {
        this.productSize = productSize;
        this.productColor = productColor;
        this.productQty = productQty;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductQty() {
        return productQty;
    }

    public void setProductQty(String productQty) {
        this.productQty = productQty;
    }
}
