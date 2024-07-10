package PageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public String emailInput="//android.widget.EditText";
    public String loginButton="//android.widget.Button[@text=\"Log in\"]";
    public String passwordInput="new UiSelector().className(\"android.widget.EditText\").instance(1)";

    public AppiumDriver driver;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }


    public void enterEmail(String email) {
        WebElement emailField=driver.findElement(By.xpath(emailInput));
        emailField.sendKeys(email);
        clickLogin();
    }

    public void enterPassword(String password) {
        WebElement passwordField=driver.findElement(AppiumBy.androidUIAutomator(passwordInput));
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(By.xpath(loginButton)).click();
    }

    public boolean isLoginPageOpened() {
        return driver.findElement(By.xpath(loginButton)).isDisplayed();
    }

    public boolean validateEmail(String email) {
        return email.equals(driver.findElement(By.xpath(emailInput)).getText());
    }

    public boolean validatePassword(String password) {
        return password.equals(driver.findElement(AppiumBy.androidUIAutomator(passwordInput)).getText());
    }
}
