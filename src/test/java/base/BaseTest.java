package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CreateProfileLobbyPage;
import pages.HomePage;
import pages.LoginPage;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());

        driver.get("https://eon.tv/");
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
    }

    @Test
    public void test() {

        LoginPage login = homePage.clickLogin();
        login.selectProvider();
        login.sendUsername();
        login.sendPassword();

         CreateProfileLobbyPage profileLobby = login.clickSubmit();
         profileLobby.clickCreateProfile();
    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        return options;
    }
}
