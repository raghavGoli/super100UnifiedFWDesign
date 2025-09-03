package com.everShop.api.pojo.response.login;

public class Data {

    private String sid;


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Data{" +
                "sid='" + sid + '\'' +
                '}';
    }
}
