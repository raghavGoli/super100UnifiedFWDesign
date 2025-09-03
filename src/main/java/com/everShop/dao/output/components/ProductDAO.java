package com.everShop.dao.output.components;

public class ProductDAO {

    private String productName;
    private String skuLabel;

    private float price;

    private int qty;

    private float totalPrice;

    private String color;

    private String size;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSkuLabel() {
        return skuLabel;
    }

    public void setSkuLabel(String skuLabel) {
        this.skuLabel = skuLabel;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ProductDAO{" +
                "productName='" + productName + '\'' +
                ", skuLabel='" + skuLabel + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", totalPrice=" + totalPrice +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
