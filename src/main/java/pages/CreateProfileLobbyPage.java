package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static elementUtils.ElementUtils.waitForElementToBeClickable;

public class CreateProfileLobbyPage {

    private WebDriver driver;

    @FindBy(xpath = "//button[@class='create-profile-button button common-primary']")
    private WebElement createProfileButton;

    public CreateProfileLobbyPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateNewProfilePage clickCreateProfile() {

        waitForElementToBeClickable(driver, createProfileButton).click();
        return new CreateNewProfilePage(driver);
    }
}
