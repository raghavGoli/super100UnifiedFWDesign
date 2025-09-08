package com.everShop.api.pojo.response.fetchproducts;

public class RootFetchProducts {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RootFetchProducts{" +
                "data=" + data +
                '}';
    }
}
