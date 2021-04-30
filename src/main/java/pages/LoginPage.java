package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static elementUtils.ElementUtils.selectDropdownOption;
import static elementUtils.ElementUtils.waitForElementToBeClickable;

public class LoginPage {

    private WebDriver driver;

    private static final String username = "eon.test2";
    private static final String password = "N@vig@tor2o2o";

    @FindBy(xpath = "//div[@class='dropdown placeholder']")
    private WebElement serviceProviderDropdown;

    @FindBy(xpath = "//div[@class='dropdown-list-item']")
    private List<WebElement> dropdownOptions;

    @FindBy(id = "user_name")
    private WebElement usernameField;

    @FindBy(id = "user_password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='submit-btn button common-primary']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@class='button common-primary']")
    private WebElement acceptCookies;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectProvider() {

        waitForElementToBeClickable(driver, serviceProviderDropdown).click();
        selectDropdownOption(dropdownOptions, "SBB");
    }

    public void sendUsername() {

        usernameField.sendKeys(username);
    }

    public void sendPassword() {

        passwordField.sendKeys(password);
    }

    public void clickSubmit() {

        acceptCookies.click();
        submitButton.click();
    }

    public CreateProfileLobbyPage loginToProfileLobbyPage() {

        selectProvider();
        sendUsername();
        sendPassword();
        clickSubmit();
        return new CreateProfileLobbyPage(driver);
    }
}
