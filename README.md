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
Login Test

1. Valid/Invalid credentials
2. Signup and login flow
3. Add to Cart
4. Add multiple products
5. Remove product from cart
6. Place Order
7. Fill form and verify order success
8. Check confirmation modal
9. Navigation Test
10. Filter by category (phones/laptops)

### Tools Used

* Selenium WebDriver
* Java
* TestNG
* Maven
* ExtentReports (for reporting)
* Apache POI (for Excel handling) 
* Log4j / SLF4J (for logging)