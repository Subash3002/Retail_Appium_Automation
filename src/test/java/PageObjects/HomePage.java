package PageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

import static PageObjects.OtherMethods.scrollUpTo;

public class HomePage {
    public AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public String loginButton="new UiSelector().resourceId(\"blibli.mobile.commerce:id/bt_login\")";
    public String searchBox="new UiSelector().resourceId(\"blibli.mobile.commerce:id/tv_search\")";
    public String searchInputBox="new UiSelector().resourceId(\"blibli.mobile.commerce:id/et_search_box\")";
    public String searchButton="new UiSelector().resourceId(\"blibli.mobile.commerce:id/iv_search_button\")";
    public String filterButton="new UiSelector().text(\"Filter\")";
    public String locationFilter="new UiSelector().resourceId(\"blibli.mobile.commerce:id/ll_options\").instance(5)";
    public String colorFilter="new UiSelector().text(\"Multicolor\")";
    public String productStockFilter="new UiSelector().text(\"Ready Stock\")";
    public String applyButton="//android.widget.Button[@resource-id=\"blibli.mobile.commerce:id/btn_apply\"]";
    public String locationApplied="new UiSelector().text(\"Jabodetabek\").instance(0)";
    public String sortFIlter="new UiSelector().text(\"Terpopuler\")";
    public String sortExpensive="new UiSelector().text(\"Termahal\")";
    public String expensiveProduct="new UiSelector().resourceId(\"blibli.mobile.commerce:id/btn_cta\").instance(0)";
    public String addToCartButton ="blibli.mobile.commerce:id/btn_add_to_cart";
    public String bagIcon="blibli.mobile.commerce:id/iv_cart";
    public String searchInputDisplayed="blibli.mobile.commerce:id/citv_search_term";
    public String productListed="new UiSelector().resourceId(\"blibli.mobile.commerce:id/cl_parent\").instance(1)";
    public String activityTitle="blibli.mobile.commerce:id/tv_title";
    public String filterCount="blibli.mobile.commerce:id/tv_option_selected_count";

    public boolean isLoginButtonVisible(){
        return driver.findElement(AppiumBy.androidUIAutomator(loginButton)).isDisplayed();
    }

    public void searchProduct(String product) {
        driver.findElement(AppiumBy.androidUIAutomator(searchBox)).click();
        driver.findElement(AppiumBy.androidUIAutomator(searchInputBox)).sendKeys(product);
        driver.findElement(AppiumBy.androidUIAutomator(searchButton)).click();
    }

    public void openFilter() {
        driver.findElement(AppiumBy.androidUIAutomator(filterButton)).click();
    }

    public void applyLocationFilter(){
        driver.findElement(AppiumBy.androidUIAutomator(locationFilter)).click();
    }

    public void applyColorFilter(){
        scrollUpTo(driver);
        driver.findElement(AppiumBy.androidUIAutomator(colorFilter)).click();


    }

    public void applyProductStockFilter(){
        scrollUpTo(driver);
        driver.findElement(AppiumBy.androidUIAutomator(productStockFilter)).click();
    }


    public void applySelectedFilters(){
        driver.findElement(AppiumBy.xpath(applyButton)).click();
    }

    public boolean isLocationFilterApplied() {
        return driver.findElement(AppiumBy.androidUIAutomator(locationApplied)).isDisplayed();
    }

    public boolean isColorFilterApplied() {
        return driver.findElement(AppiumBy.androidUIAutomator(colorFilter)).isDisplayed();
    }

    public boolean isProductStockFilterApplied(){
        return driver.findElement(AppiumBy.androidUIAutomator(productStockFilter)).isDisplayed();
    }

    public void applySortFilter(){
        driver.findElement(AppiumBy.androidUIAutomator(sortFIlter)).click();
    }

    public void selectExpensiveProduct(){
        driver.findElement(AppiumBy.androidUIAutomator(sortExpensive)).click();
        driver.findElement(AppiumBy.androidUIAutomator(expensiveProduct)).click();
    }

    public void addToCart() {
        driver.findElement(By.id(addToCartButton)).click();
    }

    public void moveToCart(){
        driver.findElement(By.id(bagIcon)).click();
    }

    public boolean validateProductName(String productName) {
        System.out.println(driver.findElement(By.id(searchInputDisplayed)).getText());
        return productName.equals(driver.findElement(By.id(searchInputDisplayed)).getText());
    }

    public boolean isProductsDisplayed() {
        return driver.findElement(AppiumBy.androidUIAutomator(productListed)).isDisplayed();
    }

    public String getCurrentTitle() {
        return driver.findElement(By.id(activityTitle)).getText();
    }

    public String getFilterCount() {
        return driver.findElement(By.id(filterCount)).getText();
    }
}
