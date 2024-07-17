package StepDefinitions;

import PageObjects.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MyStepdefs {
    public DesiredCapabilities capabilities;
    public AppiumDriver driver;
    public HomePage homePage;
    public LoginPage loginPage;
    public CartPage cartPage;
    public CheckOut checkOut;
    public OrderDetailsPage orderDetailsPage;

    @Given("the user has the blibli application in the mobile")
    public void theUserHasTheBlibliApplicationInTheMobile() {
        capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 8");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability("noReset",true);
        capabilities.setCapability(MobileCapabilityType.APP,"/Users/subash/Downloads/Blibli.apk");
        capabilities.setCapability("udid", "emulator-5556");

    }

    @When("the user launches the blibli application")
    public void theUserLaunchesTheBlibliApplication() throws MalformedURLException {
        driver=new AndroidDriver(new URL("http://127.0.0.1:4722/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage=new HomePage(driver);
        cartPage=new CartPage(driver);
        loginPage=new LoginPage(driver);
        orderDetailsPage=new OrderDetailsPage(driver);
        checkOut=new CheckOut(driver);
    }

    @Then("the user should see the login button")
    public void theUserShouldSeeTheLoginButton() {
        Assert.assertTrue(homePage.isLoginButtonVisible(),"not in correct page");
    }

    @When("the user searches {string}")
    public void theUserSearches(String product) {
        homePage.searchProduct(product);
    }

    @When("the user click filter button to apply filters")
    public void theUserClickFilterButtonToApplyFilters() {
        homePage.openFilter();
    }

    @When("the user chooses location filter")
    public void theUserChoosesLocationFilter() {
        homePage.applyLocationFilter();
    }

    @When("the user chooses color filter")
    public void theUserChoosesColorFilter() throws InterruptedException {
        homePage.applyColorFilter();
    }

    @When("the user chooses product stock filter")
    public void theUserChoosesProductStockFilter() throws InterruptedException {
        homePage.applyProductStockFilter();
    }

    @When("the user applies the selected filters")
    public void theUserAppliesTheSelectedFilters() {
        homePage.applySelectedFilters();
    }

    @Then("the user should see the location filter applied")
    public void theUserShouldSeeTheLocationFilterApplied() {
        Assert.assertTrue(homePage.isLocationFilterApplied(),"Location filter not applied");
    }

    @Then("the user should see the color filter applied")
    public void theUserShouldSeeTheColorFilterApplied() {
        Assert.assertTrue(homePage.isColorFilterApplied(),"Color filter not applied");
    }

    @Then("the user should see the product stock filter applied")
    public void theUserShouldSeeTheProductStockFilterApplied() {
        Assert.assertTrue(homePage.isProductStockFilterApplied(),"Product stock filter not applied");
    }

    @When("the user selects sort filter")
    public void theUserSelectsSortFilter() {
        homePage.applySortFilter();
    }

    @When("the user selects the expensive product after applying filters")
    public void theUserSelectsTheExpensiveProductAfterApplyingFilters() {
        homePage.selectExpensiveProduct();
    }

    @When("the user moves to the cart")
    public void theUserMovesToTheCart() {
        homePage.moveToCart();
    }

    @When("the user enters email {string}")
    public void theUserEntersEmail(String email) {
        loginPage.enterEmail(email);
    }

    @When("the user enters password {string}")
    public void theUserEntersPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user clicks login button")
    public void theUserClicksLoginButton() {
        loginPage.clickLogin();
    }

    @When("the user add quantity of the product")
    public void theUserAddQuantityOfTheProduct() {
        cartPage.addQuantity();
    }

    @When("the user wishlist the product")
    public void theUserWishlistTheProduct() {
        cartPage.wishListTheProduct();
    }

    @When("the user checkout the product")
    public void theUserCheckoutTheProduct() {
        cartPage.checkoutProduct();
    }


    @When("the user makes payment")
    public void theUserMakesPayment() throws InterruptedException {
        checkOut.doPayment();
        orderDetailsPage.navigateHome();
    }

    @When("the user cancels the order")
    public void theUserCancelsTheOrder() throws InterruptedException {
        orderDetailsPage.cancelOrder();
    }

    @When("the user navigates to orders list")
    public void theNavigatesToOrdersList() {
        orderDetailsPage.goToOrders();
    }

    @Then("the user should see the {string} displayed in searchbar")
    public void theUserShouldSeeTheDisplayedInSearchbar(String productName) {
        Assert.assertTrue(homePage.validateProductName(productName),"The product is not searched");
    }

    @Then("the user sees the listed products")
    public void theUserSeesTheListedProducts() {
        Assert.assertTrue(homePage.isProductsDisplayed(),"The products are not displayed");
    }

    @Then("the user should see the filter tab opened")
    public void theUserShouldSeeTheFilterTabOpened() {
        Assert.assertEquals("Filter",homePage.getCurrentTitle(),"The filter tab is not opened");
    }

    @Then("the user should see the total count {string} in applied filter")
    public void theUserShouldSeeTheTotalCountInAppliedFilter(String filterCount) {
        Assert.assertEquals(filterCount,homePage.getFilterCount(),"All filters are not applied");
    }

    @Then("the user should see the login page opened for user login")
    public void theUserShouldSeeTheLoginPageOpenedForUserLogin() {
        Assert.assertTrue(loginPage.isLoginPageOpened(),"Login page is not opened");
    }

    @Then("the user should see the {string} in the email input field")
    public void theUserShouldSeeTheInTheEmailInputField(String email) {
        Assert.assertTrue(loginPage.validateEmail(email),"Email is mismatched");
    }

    @Then("the user should see the {string} in the password input field")
    public void theUserShouldSeeTheInThePasswordInputField(String password) {
        Assert.assertTrue(loginPage.validatePassword(password),"Password is mismatched");
    }

    @Then("the user navigates to cart page")
    public void theUserNavigatesToCartPage() {
        Assert.assertTrue(cartPage.isUserInCart(),"User is not in cart");
    }

    @When("the user selects the payment option by choosing {string}")
    public void theUserSelectsThePaymentOptionByChoosing(String bankName) throws InterruptedException {
        checkOut.choosePayment();
        checkOut.chooseBank(bankName);
    }

    @Then("the user see the quantity changed to {string}")
    public void theUserSeeTheQuantityChangedTo(String productCount) {
        Assert.assertEquals(cartPage.getProductQuantity(),productCount,"Product Quantity incorrect");
    }

    @Then("the user goes to payment page")
    public void theUserGoesToPaymentPage() {
        Assert.assertTrue(checkOut.isUserNavigatedToPayment(),"The user is not in payment page");
    }

    @Then("the user navigated to home page")
    public void theUserNavigatedToHomePage() {
        Assert.assertTrue(orderDetailsPage.isNavigatedToHome(),"The user not in home page");
    }

    @Then("the ordered product should be displayed")
    public void theOrderedProductShouldBeDisplayed() {
        Assert.assertTrue(orderDetailsPage.isOrderedProductVisible(),"The ordered product not visible");
    }

    @Then("the user should see {string} selected")
    public void theUserShouldSeeSelected(String bankName) {
        Assert.assertEquals(bankName,checkOut.getChoosenBank().trim(),"Bank not updated");
    }

    @Then("the user should see the payment status as {string}")
    public void theUserShouldSeeThePaymentStatusAs(String cancelStatus) {
        Assert.assertEquals(cancelStatus,orderDetailsPage.getPaymentStatus(),"Order not cancelled");
    }

    @Then("the verifies the product details")
    public void theVerifiesTheProductDetails() {
        Assert.assertEquals(cartPage.getProductName(),homePage.getProductName(),"Product name mismatch");
        Assert.assertEquals(cartPage.getProductPrice(),homePage.getProductPrice(),"Product price mismatch");
    }

    @Then("the user should see the {string} message")
    public void theUserShouldSeeTheMessage(String cancelMessage) {
        Assert.assertEquals(cancelMessage,orderDetailsPage.getCancelStatus(),"Order cancelled message not displayed");
    }
}
