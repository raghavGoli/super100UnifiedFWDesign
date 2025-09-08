package com.everShop.api.applicationdao;

public class ApplicationAPIDao {

    private LoginAPIDao loginAPIDao;

    private ProductsAPIDao productsAPIDao;

    private CreateCartAPIDao createCartAPIDao;

    public CreateCartAPIDao getCreateCartAPIDao() {
        return createCartAPIDao;
    }

    public void setCreateCartAPIDao(CreateCartAPIDao createCartAPIDao) {
        this.createCartAPIDao = createCartAPIDao;
    }

    public ProductsAPIDao getProductsDao() {
        return productsAPIDao;
    }

    public void addProductToProductsDao(ProductAPIDao productAPIDao) {
        if(productsAPIDao == null){
            productsAPIDao = new ProductsAPIDao();
        }
        productsAPIDao.addProductToList(productAPIDao);
    }


    public LoginAPIDao getLoginAPIDao() {
        return loginAPIDao;
    }

    public void setLoginAPIDao(LoginAPIDao loginAPIDao) {
        this.loginAPIDao = loginAPIDao;
    }

    @Override
    public String toString() {
        return "ApplicationAPIDao{" +
                "loginAPIDao=" + loginAPIDao +
                ", productsAPIDao=" + productsAPIDao +
                ", createCartAPIDao=" + createCartAPIDao +
                '}';
    }
}
