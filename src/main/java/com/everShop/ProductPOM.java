package com.everShop;

import com.everShop.dao.input.ProductInputDAO;
import com.everShop.utility.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPOM extends BasePOM {
    public ProductPOM(WebDriver wd) {
        super(wd);
    }

    private By addToCartButton = By.xpath("//span[text()='ADD TO CART']/parent::button");
    private String itemSizeChkBox = "//ul[contains(@class,'variant-option-list')]/li//a[text()='$$$']";
    private String itemColorChkBox = "//ul[contains(@class,'variant-option-list')]/li//a[text()='$$$']";
    private By itemQntyInput = By.xpath("//input[@placeholder='Qty']");
    private By viewCartButton = By.xpath("//a[@href='/cart']");
    private By productNameTitle = By.xpath("//h1[@class='product-single-name']");

    public By getItemSizeLocator(String sizeOrColor) {
        String itemSizeLocator = itemSizeChkBox.replace("$$$", sizeOrColor);
        return By.xpath(itemSizeLocator);
    }

    public By getItemColorLocator(String sizeOrColor) {
        String itemColorLocator = itemColorChkBox.replace("$$$", sizeOrColor);
        return By.xpath(itemColorLocator);
    }


    public ProductPOM fillItemQty(String quantity) {
        wd.findElement(itemQntyInput).clear();
        wd.findElement(itemQntyInput).sendKeys(quantity);
        return this;
    }

    public ProductPOM selectItemSize(String size) {
        By element = getItemSizeLocator(size);
        wd.findElement(element).click();
        WaitManager.waitForElementToHaveAtrributeWithSpecificValue(wd, wd.findElement(element).findElement(By.xpath("parent::li")), "class", "selected");
        return this;
    }

    public ProductPOM selectItemColor(String color) {
        By element = getItemColorLocator(color);
        wd.findElement(element).click();
        WaitManager.waitForElementToHaveAtrributeWithSpecificValue(wd, wd.findElement(element).findElement(By.xpath("parent::li")), "class", "selected");
        return this;
    }

    public ProductPOM clickAddToCartBtn() {
        wd.findElement(addToCartButton).click();
        WaitManager.waitForElementToBeLocated(wd, viewCartButton);
        return this;

    }

    public CartPOM clickViewCartButton() {
        wd.findElement(viewCartButton).click();
        return new CartPOM(wd);
    }

    public ProductPOM fillProductDetails(ProductInputDAO productInputDAO) {

        selectItemSize(productInputDAO.getProductSize()).selectItemColor(productInputDAO.getProductColor())
                .fillItemQty(productInputDAO.getProductQty());
        return this;
    }
}
