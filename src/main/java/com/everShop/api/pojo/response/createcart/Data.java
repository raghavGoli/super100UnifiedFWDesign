package com.everShop.api.pojo.response.createcart;

public class Data {

    private List<Item> items;
    private int count;
    private String cartId;

    public List<Item> getItem() {
        return items;
    }

    public void setItem(List<Item> items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "Data{" +
                "item=" + items +
                ", count=" + count +
                ", cartId='" + cartId + '\'' +
                '}';
    }
}
