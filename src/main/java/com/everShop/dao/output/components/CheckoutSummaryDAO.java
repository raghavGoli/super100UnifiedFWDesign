package com.everShop.dao.output.components;

public class CheckoutSummaryDAO {


    private int itemsCount;
    private String deliveryType;
    private float discountPrice;
    private float shippingPrice;
    private float subTotalPrice;
    private float totalFinalPrice;
    private float taxPrice;

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public float getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(float taxPrice) {
        this.taxPrice = taxPrice;
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

    public float getTotalFinalPrice() {
        return totalFinalPrice;
    }

    public void setTotalFinalPrice(float totalFinalPrice) {
        this.totalFinalPrice = totalFinalPrice;
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

    @Override
    public String toString() {
        return "CheckoutSummaryDAO{" +
                "itemsCount=" + itemsCount +
                ", deliveryType='" + deliveryType + '\'' +
                ", discountPrice=" + discountPrice +
                ", shippingPrice=" + shippingPrice +
                ", subTotalPrice=" + subTotalPrice +
                ", totalFinalPrice=" + totalFinalPrice +
                ", taxPrice=" + taxPrice +
                '}';
    }
}
