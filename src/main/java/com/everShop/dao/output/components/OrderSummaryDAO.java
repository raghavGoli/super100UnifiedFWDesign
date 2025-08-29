package com.everShop.dao.output.components;

import java.util.List;
import java.util.Objects;

public class OrderSummaryDAO {

    private float subTotal;

    private int itemsCount;
    private float shipppingCharges;

    private String shippingMethodType;

    private List<ProductDAO> purchasedProducts;

    private float totalOrderPrice;

    private float taxes;

    private float discount;

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public float getShipppingCharges() {
        return shipppingCharges;
    }

    public void setShipppingCharges(float shipppingCharges) {
        this.shipppingCharges = shipppingCharges;
    }

    public float getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(float totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    public float getTaxes() {
        return taxes;
    }

    public void setTaxes(float taxes) {
        this.taxes = taxes;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getShippingMethodType() {
        return shippingMethodType;
    }

    public void setShippingMethodType(String shippingMethodType) {
        this.shippingMethodType = shippingMethodType;
    }

    public List<ProductDAO> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(List<ProductDAO> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    @Override
    public String toString() {
        return "OrderSummaryDao{" +
                "subTotal=" + subTotal +
                ", itemsCount=" + itemsCount +
                ", shipppingCharges=" + shipppingCharges +
                ", shippingMethodType='" + shippingMethodType + '\'' +
                ", purchasedProducts=" + purchasedProducts +
                ", totalOrderPrice=" + totalOrderPrice +
                ", taxes=" + taxes +
                ", discount=" + discount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderSummaryDAO that = (OrderSummaryDAO) o;
        return Float.compare(subTotal, that.subTotal) == 0 && itemsCount == that.itemsCount && Float.compare(shipppingCharges, that.shipppingCharges) == 0 && Float.compare(totalOrderPrice, that.totalOrderPrice) == 0 && Float.compare(taxes, that.taxes) == 0 && Float.compare(discount, that.discount) == 0 && Objects.equals(shippingMethodType, that.shippingMethodType) && Objects.equals(purchasedProducts, that.purchasedProducts);
    }

}
