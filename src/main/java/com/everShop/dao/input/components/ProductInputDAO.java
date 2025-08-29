package com.everShop.dao.input.components;

public class ProductInputDAO {

    private String productSize;
    private String productColor;
    private String productQty;
    private float productPrice;

    public ProductInputDAO(String productSize, String productColor, String productQty,float productPrice) {
        this.productSize = productSize;
        this.productColor = productColor;
        this.productQty = productQty;
        this.productPrice = productPrice;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
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

    @Override
    public String toString() {
        return "ProductInputDAO{" +
                "productSize='" + productSize + '\'' +
                ", productColor='" + productColor + '\'' +
                ", productQty='" + productQty + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
