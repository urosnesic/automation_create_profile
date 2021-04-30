package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static elementUtils.ElementUtils.waitForElementToBeClickable;

public class HomePage {

    private WebDriver driver;

    @FindBy(linkText = "Uloguj se")
    private WebElement loginButton;

    public HomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickLogin() {

        waitForElementToBeClickable(driver, loginButton).click();
        return new LoginPage(driver);
    }
}
