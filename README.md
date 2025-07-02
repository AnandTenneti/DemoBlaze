Demoblaze is a sample e-commerce site developed by Mercury, featuring:

Product categories (Phones, Laptops, Monitors)

Add to cart and delete functionality

Signup/Login

Checkout and place order



bash
Copy
Edit
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

base/: Contains BaseTest class that sets up and tears down WebDriver sessions.

pages/: Follows the Page Object Model (POM) — each page of the app has a corresponding class with WebElements and methods.

tests/: Actual test classes that call methods from the pages package.

utils/: Reusable utilities like wait methods, logger config, Excel reading, screenshot capturing.

data/: Optional; data providers for parameterized tests.

resources/: Configuration and data files, e.g., config.properties, test data, locator files.

Tools Commonly Used
Selenium WebDriver

TestNG / JUnit

Maven / Gradle

ExtentReports / Allure (for reporting)

Log4j / SLF4J (for logging)