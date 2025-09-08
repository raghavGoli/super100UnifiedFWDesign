package com.everShop.api.pojo.response.createcart;

import java.util.ArrayList;

public class Products {

    private ArrayList<Item> items;

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Products{" +
                "items=" + items +
                '}';
    }
}
