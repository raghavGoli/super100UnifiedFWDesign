package com.everShop.api.applicationdao;

import java.util.ArrayList;
import java.util.List;

public class ProductsAPIDao {

    private List<ProductAPIDao> productList;

    public ProductsAPIDao() {
        productList = new ArrayList<>();
    }

    public List<ProductAPIDao> getProductList() {
        return productList;
    }

    public void addProductToList(ProductAPIDao product) {
        productList.add(product);
    }

    @Override
    public String toString() {
        return "ProductsDao{" +
                "productList=" + productList +
                '}';
    }
}
