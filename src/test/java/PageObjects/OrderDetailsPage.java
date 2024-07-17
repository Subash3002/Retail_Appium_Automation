package PageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static PageObjects.OtherMethods.scrollDown;
import static PageObjects.OtherMethods.scrollUpTo;

public class OrderDetailsPage {
    public String cancelOrderButton="new UiSelector().resourceId(\"blibli.mobile.commerce:id/bt_cancel_order\")";
    public String confirmCancelButton="blibli.mobile.commerce:id/bt_one";
    public String returnHomeButton="blibli.mobile.commerce:id/tv_return_home";
    public String orderList="new UiSelector().resourceId(\"blibli.mobile.commerce:id/navigation_bar_item_icon_container\").instance(3)";
    public String orderedProduct="new UiSelector().resourceId(\"blibli.mobile.commerce:id/tv_product_name\")";
    public String paymentStatus="blibli.mobile.commerce:id/tv_payment_status";
    public String finalCancelButtom="blibli.mobile.commerce:id/bt_expanded_one";
    public String orderTitle="new UiSelector().text(\"Order detail\")";
    public String canceledAlert="blibli.mobile.commerce:id/alert_box_button_vertically";
    public String orderPrice="new UiSelector().resourceId(\"blibli.mobile.commerce:id/tv_total_cost\")";
    public String canceledMessage="new UiSelector().resourceId(\"blibli.mobile.commerce:id/tvLabel\")";


    public AppiumDriver driver;
    public WebDriverWait wait;

    public OrderDetailsPage(AppiumDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    public void cancelOrder() throws InterruptedException {
        driver.findElement(AppiumBy.androidUIAutomator(orderedProduct)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.androidUIAutomator(orderTitle))));
        scrollUpTo(driver);
        scrollUpTo(driver);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(AppiumBy.androidUIAutomator(cancelOrderButton)))).click();
        driver.findElement(By.id(confirmCancelButton)).click();
        driver.findElement(By.id(finalCancelButtom)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(canceledAlert)))).click();
        scrollDown(driver);
    }

    public void navigateHome() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(paymentStatus))));
        scrollUpTo(driver);
        driver.findElement(By.id(returnHomeButton)).click();
    }

    public void goToOrders(){
        driver.findElement(AppiumBy.androidUIAutomator(orderList)).click();
    }

    public boolean isNavigatedToHome(){
        return driver.findElement(AppiumBy.androidUIAutomator(orderList)).isDisplayed();
    }

    public boolean isOrderedProductVisible(){
        return driver.findElement(AppiumBy.androidUIAutomator(orderedProduct)).isDisplayed();
    }

    public String getPaymentStatus(){
        return driver.findElement(By.id(paymentStatus)).getText();
    }

    public String getCancelStatus(){
        return driver.findElement(AppiumBy.androidUIAutomator(canceledMessage)).getText();
    }


}
