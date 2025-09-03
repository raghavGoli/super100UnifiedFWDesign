package com.everShop.web.dao.input.components;

public class LoginInputDAO {

    private String email;

    public String getPassword() {
        return password;
    }
    public LoginInputDAO() {
    }

    public LoginInputDAO(String emailId, String password) {
        this.email = emailId;
        this.password = password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String password;


    @Override
    public String toString() {
        return "LoginInputDAO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
