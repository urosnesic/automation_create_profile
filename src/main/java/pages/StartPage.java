package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static elementUtils.ElementUtils.waitForElementToBeClickable;
import static elementUtils.ElementUtils.waitForInvisibility;

public class StartPage {

    private WebDriver driver;

    private By pageLoader = By.xpath("//div[@class='page-loader-container BackgroundDimspinner plc--visible']");

    @FindBy(xpath = "//span[contains(text(), 'Podešavanja')]")
    private WebElement settings;

    @FindBy(xpath = "//span[@class='account-name BodyLRegular']")
    private WebElement profileName;

    @FindBy(xpath = "//span[contains(text(),'Moj profil')]")
    private WebElement myProfile;

    @FindBy(xpath = "//input[@maxlength='32']")
    private WebElement fieldWithProfileName;

    @FindBy(xpath = "//button[@class='button flat']")
    private WebElement oK;

    @FindBy(xpath = "//button[contains(text(), 'Obriši profil')]")
    private WebElement deleteProfile;

    public StartPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickMyProfile() {

        waitForElementToBeClickable(driver, myProfile).click();
    }

    public void clickSettings() {

        waitForElementToBeClickable(driver, settings).click();
    }

    public WebElement getFieldWithProfileName() {

        return waitForElementToBeClickable(driver, fieldWithProfileName);
    }

    public void clickOk() {

        waitForElementToBeClickable(driver, oK).click();
    }

    public void waitInvisibility() {

        waitForInvisibility(driver, pageLoader);
    }

    public void clickDeleteProfile() {

        deleteProfile.click();
    }
}
