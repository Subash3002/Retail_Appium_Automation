package PageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static PageObjects.OtherMethods.scrollUpTo;

public class OrderDetailsPage {
    public String cancelOrderButton="new UiSelector().resourceId(\"blibli.mobile.commerce:id/bt_cancel_order\")";
    public String confirmCancelButton="blibli.mobile.commerce:id/bt_one";
    public String returnHomeButton="blibli.mobile.commerce:id/tv_return_home";
    public String orderList="new UiSelector().resourceId(\"blibli.mobile.commerce:id/navigation_bar_item_icon_container\").instance(3)";
    public String orderedProduct="new UiSelector().resourceId(\"blibli.mobile.commerce:id/tv_product_name\")";
    public String paymentStatus="blibli.mobile.commerce:id/tv_payment_status";
    public String finalCancelButtom="blibli.mobile.commerce:id/bt_expanded_one";

    public AppiumDriver driver;
    public WebDriverWait wait;

    public OrderDetailsPage(AppiumDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    public void cancelOrder(){
        driver.findElement(AppiumBy.androidUIAutomator(orderedProduct)).click();
        scrollUpTo(driver);
        scrollUpTo(driver);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(AppiumBy.androidUIAutomator(cancelOrderButton)))).click();
        driver.findElement(By.id(confirmCancelButton)).click();
        driver.findElement(By.id(finalCancelButtom)).click();
    }

    public void navigateHome() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(paymentStatus))));
        scrollUpTo(driver);
        driver.findElement(By.id(returnHomeButton)).click();
    }

    public void goToOrders(){
        driver.findElement(AppiumBy.androidUIAutomator(orderList)).click();
    }


}
