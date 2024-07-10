package PageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static PageObjects.OtherMethods.scrollUpTo;

public class CheckOut {
    public String paymentSelection="blibli.mobile.commerce:id/tv_change_payment";
    public String bankOption="new UiSelector().text(\"BANK\")";
    public String choosePayment="blibli.mobile.commerce:id/bt_choose";
    public String payButton="blibli.mobile.commerce:id/btn_pay";
    public String continuePaymentButton="blibli.mobile.commerce:id/bt_expanded_one";


    public AppiumDriver driver;


    public CheckOut(AppiumDriver driver) {
        this.driver = driver;
    }


    public void choosePayment() throws InterruptedException {
        scrollUpTo(driver);
        driver.findElement(By.id(paymentSelection)).click();
    }

    public void chooseBank(String bankName){
        driver.findElement(AppiumBy.androidUIAutomator(bankOption.replace("BANK",bankName))).click();
        driver.findElement(By.id(choosePayment)).click();
    }

    public void doPayment(){
        driver.findElement(By.id(payButton)).click();
        try{
            driver.findElement(By.id(continuePaymentButton)).click();
        }catch (Exception e){
            System.out.println(e);
        }

    }


    public boolean isUserNavigatedToPayment() {
        return driver.findElement(By.id(payButton)).isDisplayed();
    }
}
