package com.everShop.web.dao.output;

import com.everShop.web.dao.output.components.ProductDAO;

import java.util.List;

public class HomeOutputDAO {

    private List<ProductDAO> featuredProducts;

    public List<ProductDAO> getFeaturedProducts() {
        return featuredProducts;
    }

    public void setFeaturedProducts(List<ProductDAO> featuredProducts) {
        this.featuredProducts = featuredProducts;
    }

    @Override
    public String toString() {
        return "HomeOutputDAO{" +
                "featuredProducts=" + featuredProducts +
                '}';
    }
}
