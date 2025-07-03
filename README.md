   ### About the Project

Demoblaze is a sample e-commerce site developed by Mercury, featuring:
* Product categories (Phones, Laptops, Monitors)   
* Add to cart and delete functionality
* Signup/Login
* Checkout and place order

### Project Structure

<pre>
.
├── logs
│   └── browserstack-plugin.log
├── pom.xml
├── README.md
├── screenshots
│   ├── Surefire test_scrollToElementView_failure.png
│   ├── Surefire test_test_LoginPage_failure.png
│   ├── Surefire test_test_sendMessage_failure.png
│   ├── Surefire test_testLoginWithInvalidCredentials_failure.png
│   ├── Surefire test(failed)_scrollToElementView_failure.png
│   └── Surefire test(failed)_test_LoginPage_failure.png
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── pages
│   │   │           ├── CartPage.java
│   │   │           ├── ContactUsPage.java
│   │   │           ├── HeaderPage.java
│   │   │           ├── HomePage.java
│   │   │           ├── LocatorsRepository.java
│   │   │           ├── LoginPage.java
│   │   │           ├── PlaceOrderPage.java
│   │   │           ├── ProductDetailsPage.java
│   │   │           ├── RegistrationPage.java
│   │   │           └── SelfHealing.java
│   │   └── resources
│   └── test
│       ├── java
│       │   └── com
│       │       ├── driver
│       │       │   └── DriverManager.java
│       │       ├── tests
│       │       │   ├── BaseTest.java
│       │       │   ├── CartPageTest.java
│       │       │   ├── ContactUsTest.java
│       │       │   ├── DataSupplier.java
│       │       │   ├── HomePageTest.java
│       │       │   ├── ITestListenerClass.java
│       │       │   ├── LoginPageTest.java
│       │       │   ├── PlaceOrderTest.java
│       │       │   ├── ProductDetailsTest.java
│       │       │   └── RegisterTest.java
│       │       └── utils
│       │           └── Utils.java
│       └── resources
├── target
└── testng.xml
 
</pre>
### Folders

1. base/: Contains BaseTest class that sets up and tears down WebDriver sessions.
2. pages/: Follows the Page Object Model (POM) — each page of the app has a corresponding class 
with WebElements and methods.
3. tests/: Actual test classes that call methods from the pages package.
4. utils/: Reusable utilities like wait methods, logger config, Excel reading, screenshot capturing.
5. data/: Optional; data providers for parameterized tests.
   6. resources/: Configuration and data files, e.g., config.properties, test data, locator files.

### 🔹 Sample Test Case Ideas
1. Login Test 
   * Valid/Invalid credentials 
   * Signup and login flow
2. Add to Cart
   * Add multiple products
   * Remove product from cart
3. Place Order
   * Fill form and verify order success 
   * Check confirmation modal
4. Navigation Test 
   * Filter by category (phones/laptops)

### Tools Used

* Selenium WebDriver
* Java
* TestNG
* Maven
* ExtentReports (for reporting)
* Apache POI (for Excel handling) 
* Log4j / SLF4J (for logging)