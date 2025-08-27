package com.everShop.dao.output.components;

public class OrderSummaryDAO {

    private float subTotalPrice;
    private int itemsCount;
    private float shippingCharges;
    private String shippingMethodType;
    private float totalOrderPrice;
    private float taxPrice;
    private float discountPrice;

    public float getSubTotalPrice() {
        return subTotalPrice;
    }

    public String getShippingMethodType() {
        return shippingMethodType;
    }
    

    public void setShippingMethodType(String shippingMethodType) {
        this.shippingMethodType = shippingMethodType;
    }

    public void setSubTotalPrice(float subTotalPrice) {
        this.subTotalPrice = subTotalPrice;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public float getShippingCharges() {
        return shippingCharges;
    }

    public void setShippingCharges(float shippingCharges) {
        this.shippingCharges = shippingCharges;
    }

    public float getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(float totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    public float getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(float taxPrice) {
        this.taxPrice = taxPrice;
    }

    public float getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(float discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "OrderSummaryDAO{" +
                "subTotalPrice=" + subTotalPrice +
                ", itemsCount=" + itemsCount +
                ", shippingCharges=" + shippingCharges +
                ", shippingMethodType='" + shippingMethodType + '\'' +
                ", totalOrderPrice=" + totalOrderPrice +
                ", taxPrice=" + taxPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
