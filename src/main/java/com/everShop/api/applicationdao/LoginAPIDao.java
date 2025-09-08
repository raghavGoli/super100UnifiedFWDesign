package com.everShop.api.applicationdao;

public class LoginAPIDao {

    private String email;
    private String password;

    private String sid;
    private String sessionCookie;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSessionCookie() {
        return sessionCookie;
    }

    public void setSessionCookie(String sessionCookie) {
        this.sessionCookie = sessionCookie;
    }

    @Override
    public String toString() {
        return "LoginAPIDao{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", sid='" + sid + '\'' +
                ", sessionCookie='" + sessionCookie + '\'' +
                '}';
    }
}
