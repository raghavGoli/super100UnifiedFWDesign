package everShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPagePOM extends BasePOM{

    public loginPagePOM(WebDriver wd){
        super(wd);
    }
    private static final By email_input =By.xpath("//input[@placeholder='Email']");
    private static final By password_input =By.xpath("//input[@placeholder='Password']");
    private static final By submit_btn =By.xpath("//button[@type='submit']");

    public loginPagePOM get() {
        String resourcePath = "/account/login";
        String baseURL = "https://demo.evershop.io";
        String newURL =  baseURL.concat(resourcePath);
        wd.get(newURL);
        wd.manage().window().maximize();
        wd.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        return this;
    }

    public loginPagePOM setEmail(String email){
      wd.findElement(email_input).sendKeys(email);
      return this;
    }

    public loginPagePOM setPassword(String password){
        wd.findElement(password_input).sendKeys(password);
        return this;
    }

    public homePagePOM clickSubmitButton(){
        wd.findElement(submit_btn).click();
        return new homePagePOM(wd);

    }


    public homePagePOM loginToEverShopSite(String email,String password)
    {
        setEmail(email);
        setPassword(password);
        clickSubmitButton();
        return new homePagePOM(wd);
    }


}
