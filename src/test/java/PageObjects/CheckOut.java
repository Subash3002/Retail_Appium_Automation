package PageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import static PageObjects.OtherMethods.scrollUpTo;

public class CheckOut {
    public String paymentSelection="blibli.mobile.commerce:id/tv_change_payment";
    public String bankOption="new UiSelector().text(\"image-BRIVA BANK\")";
    public String choosePayment="blibli.mobile.commerce:id/bt_choose";
    public String payButton="blibli.mobile.commerce:id/btn_pay";
    public String continuePaymentButton="blibli.mobile.commerce:id/bt_expanded_one";
    public String choosedBank="//android.widget.TextView[@resource-id=\"blibli.mobile.commerce:id/tv_payment_desc\"]";


    public AppiumDriver driver;


    public CheckOut(AppiumDriver driver) {
        this.driver = driver;
    }


    public void choosePayment(){
        scrollUpTo(driver);
        driver.findElement(By.id(paymentSelection)).click();
    }

    public void chooseBank(String bankName){

        driver.findElement(AppiumBy.androidUIAutomator(bankOption.replace("BANK",bankName))).click();
    }


    public void doPayment() throws InterruptedException {
        Thread.sleep(5000);
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

    public String getChoosenBank(){
        return driver.findElement(By.xpath(choosedBank)).getText();
    }
}
