package com.everShop.web.dao.output.components;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductDAO that = (ProductDAO) o;
        return Float.compare(price, that.price) == 0 && qty == that.qty && Float.compare(totalPrice, that.totalPrice) == 0 && Objects.equals(productName, that.productName) && Objects.equals(skuLabel, that.skuLabel) && Objects.equals(color, that.color) && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, skuLabel, price, qty, totalPrice, color, size);
    }
}
