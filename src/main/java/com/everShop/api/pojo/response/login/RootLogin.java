package com.everShop.api.pojo.response.login;

public class RootLogin {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RootLogin{" +
                "data=" + data +
                '}';
    }
}
