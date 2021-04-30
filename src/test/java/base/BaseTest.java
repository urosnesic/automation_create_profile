package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    }

    @BeforeMethod
    public void beforeTest() {

        driver = new ChromeDriver(getChromeOptions());

        driver.get("https://eon.tv/");
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        return options;
    }
}
