package com.everShop.dao.output.components;

public class ProductDAO {

    private String productName;
    private String  productColor;
    private float productPrice;
    private String productSize;
    private int productQty;
    private float totalPrice;
    private String skuLabel ;



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSkuLabel() {
        return skuLabel;
    }

    public void setSkuLabel(String skuLabel) {
        this.skuLabel = skuLabel;
    }

    @Override
    public String toString() {
        return "ProductDAO{" +
                "productName='" + productName + '\'' +
                ", productColor='" + productColor + '\'' +
                ", productPrice=" + productPrice +
                ", productSize='" + productSize + '\'' +
                ", productQty=" + productQty +
                ", totalPrice=" + totalPrice +
                ", skuLabel='" + skuLabel + '\'' +
                '}';
    }
}
