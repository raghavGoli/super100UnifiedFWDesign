package com.everShop.api.applicationdao;

public class CreateCartAPIDao {

    private String cartID;

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    @Override
    public String toString() {
        return "CreateCartAPIDao{" +
                "cartID='" + cartID + '\'' +
                '}';
    }
}
