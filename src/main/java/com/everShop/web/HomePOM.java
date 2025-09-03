package com.everShop.web;

import com.everShop.web.dao.input.components.HomeInputDAO;
import com.everShop.web.dao.output.HomeOutputDAO;
import com.everShop.web.dao.output.components.ProductDAO;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePOM extends BasePOM {

    public HomePOM(WebDriver wd) {
        super(wd);
        homeOutputDAO = new HomeOutputDAO();
    }


    private By kidsButton = By.xpath("//a[@href='/kids']");
    private String productNameLink = "//div[@class='listing-tem']/div[contains(@class,'product-name')]/a/span[text()='$$$']";
    private By featuredproduct = By.xpath("//div[@class='listing-tem']");
    private By productName = By.xpath(".//div[contains(@class,'product-name')]//span");
    private By productPrice = By.xpath(".//div[@class='product-price-listing']//span");


    private HomeOutputDAO homeOutputDAO;


    public By getProductLinkLocator(String productName) {
        String updatedProductName = productNameLink.replace("$$$", productName);
        return By.xpath(updatedProductName);
    }


    public HomePOM getPage() {
        String resourcePath = "/";
        get(resourcePath);
        return this;
    }

    @Step("Verify whether Kids menu button is dispayed")
    public HomePOM isKidsMenuDisplayed() {
        waitForElementToBeClickable(kidsButton);
        wd.findElement(kidsButton).isDisplayed();
        return this;
    }

    @Step("Click on the Product Name")
    public ProductPOM clickProductName(HomeInputDAO homeInputDAO) {
        wd.findElement(getProductLinkLocator(homeInputDAO.getProductNames().get(0))).click();
        return new ProductPOM(wd);
    }

    public HomeOutputDAO getProductDataFromHomePage() {
        getFeaturedProducts();
        return homeOutputDAO;

    }

    public HomePOM getFeaturedProducts() {
        List<ProductDAO> productsDao = new ArrayList<>();
        List<WebElement> products = wd.findElements(featuredproduct);
        for (WebElement product : products) {
            ProductDAO productDAO = new ProductDAO();
            productDAO.setProductName(product.findElement(productName).getText());
            String price = product.findElement(productPrice).getText();
            productDAO.setPrice(Float.parseFloat(price.substring(1, price.length())));
            productsDao.add(productDAO);
        }
        homeOutputDAO.setFeaturedProducts(productsDao);
        return this;
    }
}