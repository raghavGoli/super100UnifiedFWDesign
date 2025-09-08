package com.everShop.api.pojo.response.createcart;

public class RootCreateCart {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RootCreateCart{" +
                "data=" + data +
                '}';
    }
}
