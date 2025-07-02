### About the Project

Demoblaze is a sample e-commerce site developed by Mercury, featuring:
* Product categories (Phones, Laptops, Monitors)   
* Add to cart and delete functionality
* Signup/Login
* Checkout and place order

### Project Structure

<pre>
DemoBlaze/
│
├── pom.xml                           # Maven configuration file
├── testng.xml                        # TestNG suite file (if using TestNG)
├── README.md                         # Project documentation
│── screenshots/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/                # Utility classes (e.g., ExcelUtil, WaitHelper)
│   │       └── config/              # Configuration reader or setup classes
│   │       └── base/                # BaseTest class for setup/teardown
│   │
│   └── test/
│       └── java/
│           └── tests/              # Test classes (e.g., LoginTest, SearchTest)
│           └── pages/              # Page Object Model (POM) classes
│           └── data/               # Test data providers or test data classes
│
├── src/test/resources/
│   └── config.properties            # Environment configs
│   └── testdata.xlsx                # Test data files
│   └── locators.json                # (Optional) Locator storage
│
└── reports/
└── extent-report.html  
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