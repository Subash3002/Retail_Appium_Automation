package PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    public String addButton="blibli.mobile.commerce:id/bt_qty_increment";
    public String wishListButton="blibli.mobile.commerce:id/iv_wish_list";
    public String checkoutButton="blibli.mobile.commerce:id/bt_checkout";
    public String quantityText="//android.widget.EditText[@resource-id=\"blibli.mobile.commerce:id/et_qty\"]";

    public AppiumDriver driver;

    public CartPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void addQuantity(){
        driver.findElement(By.id(addButton)).click();
    }

    public void wishListTheProduct(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(wishListButton))).click();
    }

    public void checkoutProduct(){
        driver.findElement(By.id(checkoutButton)).click();
    }

    public boolean isUserInCart() {
        return driver.findElement(By.id(checkoutButton)).isDisplayed();
    }

    public String getProductQuantity() {
        return driver.findElement(By.xpath(quantityText)).getText();
    }
}
