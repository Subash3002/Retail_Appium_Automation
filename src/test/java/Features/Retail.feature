Feature: Blibli Retail Automation
  Scenario: To purchase a product and cancel it
    Given the user has the blibli application in the mobile
    When the user launches the blibli application
    Then the user should see the login button
    When the user searches "macbook"
    Then the user sees the listed products
    When the user click filter button to apply filters
    Then the user should see the filter tab opened
    When the user chooses location filter
    Then the user should see the location filter applied
    When the user chooses color filter
    Then the user should see the color filter applied
    When the user chooses product stock filter
    Then the user should see the product stock filter applied
    When the user applies the selected filters
    Then the user should see the total count "3" in applied filter
    When the user selects sort filter
    And the user selects the expensive product after applying filters
    And the user moves to the cart
    Then the user should see the login page opened for user login
    When the user enters email "subash28122k3@gmail.com"
    Then the user should see the "subash28122k3@gmail.com" in the email input field
    When the user enters password "Password@123"
    Then the user should see the "Password@123" in the password input field
    When the user clicks login button
    Then the user navigates to cart page
    Then the verifies the product details
    When the user add quantity of the product
    And the user wishlist the product
#    Then the user see the quantity changed to "2"
    When the user checkout the product
    Then the user goes to payment page
    When the user selects the payment option by choosing "Bank BRI / Bank Lainnya"
    Then the user should see "Bank BRI / Bank Lainnya" selected
    When the user makes payment
    Then the user navigated to home page
    When the user navigates to orders list
    Then the ordered product should be displayed
    When the user cancels the order
    Then the user should see the "Canceled" message


