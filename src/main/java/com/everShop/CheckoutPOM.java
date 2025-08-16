package com.everShop;

import com.everShop.utility.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPOM extends BasePOM{

    public CheckoutPOM(WebDriver wd) {
        super(wd);
    }

    private By fullname_input = By.xpath("//input[@name='address[full_name]']");
    private By telephone_input = By.xpath("//input[@name='address[telephone]']");
    private By address_input = By.xpath("//input[@name='address[address_1]']");
    private By city_input = By.xpath("//input[@name='address[city]']");
    private By countrydrpDown = By.xpath("//select[@id='address[country]']");
    private By provincedrpDown = By.xpath("//select[@id='address[province]']");
    private By postalCode_input = By.xpath("//input[@name='address[postcode]']");
    private String shippingMethod= "//span[contains(text(),'$$$')]";
    private By continueToPaymentBtn= By.xpath("//span[text()='Continue to payment']/parent::button");
    private By placeOrder_btn= By.xpath("//span[text()='Place Order']/parent::button");
    private String paymentMethod = "//img[@alt='$$$']/parent::div/preceding-sibling::a";
    private By shippingMethodRadioWrapper = By.xpath("//div[@class='field-wrapper radio-field']");


    public By getShippingMethod(String shippingMethodName){
        String updatedShippingLocator=shippingMethod.replace("$$$",shippingMethodName)+"/ancestor::label/input";
        System.out.println(updatedShippingLocator);
        return By.xpath(updatedShippingLocator);
    }

    public CheckoutPOM setFullName(String fullName){
        WaitManager.waitForElementToBeClickable(wd,fullname_input);
        wd.findElement(fullname_input).sendKeys(fullName);
        return this;
    }
    public CheckoutPOM setTelephoneNum(String telephoneNum){
        wd.findElement(telephone_input).sendKeys(telephoneNum);
        return this;
    }

    public CheckoutPOM setAddress(String address){
        wd.findElement(address_input).sendKeys(address);
        return this;
    }

    public CheckoutPOM setCity(String cityName){
        wd.findElement(city_input).sendKeys(cityName);
        return this;
    }

    public CheckoutPOM selectCountry(String countryName){
        Select s =new Select(wd.findElement(countrydrpDown));
        s.selectByVisibleText(countryName);
        return this;
    }

    public CheckoutPOM selectProvince(String provinceName){
        Select s =new Select(wd.findElement(provincedrpDown));
        s.selectByVisibleText(provinceName);
       WaitManager.waitForElementToBeLocated(wd,shippingMethodRadioWrapper);
        return this;
    }

    public CheckoutPOM setPostalCode(String postalCodeNumber){
        wd.findElement(postalCode_input).sendKeys(postalCodeNumber);
        return this;
    }

    public CheckoutPOM clickShippingMethod(String shippingMethodName){
       ((JavascriptExecutor) wd).executeScript("arguments[0].click();", wd.findElement(getShippingMethod(shippingMethodName)));
        //WaitManager.waitForElementToBeClickable(wd,continueToPaymentBtn);
       //wd.findElement(getShippingMethod(shippingMethodName)).click();
       return this;
    }

    public CheckoutPOM clickContinueToPayment(){
        wd.findElement(continueToPaymentBtn).click();
        WaitManager.waitForElementToBeClickable(wd,placeOrder_btn);
        return this;
    }


    public By getPaymentMethodLocator(String paymentMethodName){
        String paymentMethodLocator=paymentMethod.replace("$$$",paymentMethodName);
        return By.xpath(paymentMethodLocator);
    }


    public CheckoutPOM  selectPaymentMethod(String paymentMethodName){
        ((JavascriptExecutor) wd).executeScript("arguments[0].click();", wd.findElement(getPaymentMethodLocator(paymentMethodName)));
        return this;
    }

    public SuccessPOM clickPlaceOrder(){
        wd.findElement(placeOrder_btn).click();
        return new SuccessPOM(wd);
    }

}
