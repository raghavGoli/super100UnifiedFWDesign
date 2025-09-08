package com.everShop.api.pojo.response.createcart;

public class Item {

    private int productId;
    private String uuid;
    private String name;
    private int status;
    private String sku;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return "Item{" +
                "productId=" + productId +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", sku='" + sku + '\'' +
                '}';
    }
}
