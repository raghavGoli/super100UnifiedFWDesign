package com.everShop.dao.output.components;

public class CheckoutSummaryDAO {

    private String productName;
    private String size;
    private String color;
    private String productPrice;
    private int itemsCount;
    private String deliveryType;
    private float discountPrice;
    private float shippingPrice;
    private float subTotalPrice;
    private float totalFinalPrice;
    private float taxPrice;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public float getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(float discountPrice) {
        this.discountPrice = discountPrice;
    }

    public float getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(float shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public float getSubTotalPrice() {
        return subTotalPrice;
    }

    public void setSubTotalPrice(float subTotalPrice) {
        this.subTotalPrice = subTotalPrice;
    }

    public float getTotalFinalPrice() {
        return totalFinalPrice;
    }

    public void setTotalFinalPrice(float totalFinalPrice) {
        this.totalFinalPrice = totalFinalPrice;
    }

    public float getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(float taxPrice) {
        this.taxPrice = taxPrice;
    }

    @Override
    public String toString() {
        return "CheckoutSummaryDAO{" +
                "productName='" + productName + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", itemsCount=" + itemsCount +
                ", deliveryType='" + deliveryType + '\'' +
                ", discountPrice=" + discountPrice +
                ", shippingPrice=" + shippingPrice +
                ", subTotalPrice=" + subTotalPrice +
                ", totalFinalPrice=" + totalFinalPrice +
                ", taxPrice=" + taxPrice +
                '}';
    }
}
