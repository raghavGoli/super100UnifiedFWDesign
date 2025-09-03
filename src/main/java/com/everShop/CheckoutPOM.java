package com.everShop;



import com.everShop.BasePOM;
import com.everShop.SuccessPOM;
import com.everShop.dao.input.components.CheckoutInputDAO;
import com.everShop.utility.WaitManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPOM extends BasePOM {


    private By fullNameTB = By.xpath("//input[@name='address[full_name]']");
    private By telephoneTB = By.xpath("//input[@name='address[telephone]']");
    private By address1TB = By.xpath("//input[@name='address[address_1]']");
    private By cityTB = By.xpath("//input[@name='address[city]']");
    private By postCodeTB = By.xpath("//input[@name='address[postcode]']");
    private By countryDD = By.xpath("//select[@id='address[country]']");
    private By provinceDD = By.xpath("//select[@id='address[province]']");

    //
    private String shippingMethod = "//div[@class='shipping-methods']//input//following-sibling::span[contains(text(),'$$$')]";
    private By continueToPaymentBtn = By.xpath("//button[@type='submit']/span[text()='Continue to payment']");

    private String paymentMethod = "//img[@alt='$$$']//ancestor::div[contains(@class,'payment-method-list')]//a";

    private By placeOrderBtn = By.xpath("//button/span[text()='Place Order']");

    public CheckoutPOM(WebDriver wd) {
        super(wd);
    }


    public CheckoutPOM getPage() {
        String resourcePath = "/checkout";
        get(resourcePath);
        return this;
    }


    public CheckoutPOM fillFullName(String fullName) {
        wd.findElement(fullNameTB).sendKeys(fullName);
        return this;
    }

    public CheckoutPOM fillTelephone(String telephone) {
        wd.findElement(telephoneTB).sendKeys(telephone);
        return this;
    }

    public CheckoutPOM fillAddress1(String address1) {
        wd.findElement(address1TB).sendKeys(address1);
        return this;
    }

    public CheckoutPOM fillCity(String city) {
        wd.findElement(cityTB).sendKeys(city);
        return this;
    }

    public CheckoutPOM fillPostCode(String postcode) {
        wd.findElement(postCodeTB).sendKeys(postcode);
        return this;
    }


    public CheckoutPOM selectCountry(String countryName) {
        Select s1 = new Select(wd.findElement(countryDD));
        s1.selectByVisibleText(countryName);
        return this;
    }

    public CheckoutPOM selectProvince(String provinceName ) {
        Select s1 = new Select(wd.findElement(provinceDD));
        s1.selectByVisibleText(provinceName);
        return this;
    }

    @Step("Select Shipping Method")
    public CheckoutPOM selectShippingMethod(String shippingMethodName) {
        String newPath = shippingMethod.replace("$$$", shippingMethodName);
        WaitManager.waitForElementToBeLocated(wd, By.xpath(newPath));
        wd.findElement(By.xpath(newPath)).click();
        return this;
    }

    @Step("Click Continue to Payment")
    public CheckoutPOM clickContinueToPayment() {
        wd.findElement(continueToPaymentBtn).click();
        return this;
    }

    @Step("Select Payment Method")
    public CheckoutPOM selectPaymentMethod(String paymentMethodName) {
        String newPath = paymentMethod.replace("$$$", paymentMethodName);
        WaitManager.waitForElementToBeLocated(wd,By.xpath(newPath));
        wd.findElement(By.xpath(newPath)).click();
        return this;
    }

    @Step("Click Place Order")
    public SuccessPOM clickPlaceOrder() {
        wd.findElement(placeOrderBtn).click();
        return new SuccessPOM(wd);
    }

    @Step("Fill Address Details")
    public CheckoutPOM fillAddressDetails(CheckoutInputDAO checkoutInputDao) {
        fillFullName(checkoutInputDao.getFullName())
                .fillTelephone(checkoutInputDao.getTelephoneNum())
                .fillAddress1(checkoutInputDao.getAddress())
                .fillCity(checkoutInputDao.getCity())
                .selectCountry(checkoutInputDao.getCountry())
                .selectProvince(checkoutInputDao.getProvince())
                .fillPostCode(checkoutInputDao.getPostCode());
        return this;
    }


}