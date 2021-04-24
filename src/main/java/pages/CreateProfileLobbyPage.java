package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.Utils.waitForElement;

public class CreateProfileLobbyPage {

    private WebDriver driver;

//    @FindBy(xpath = "//div[@class='create-new-holder']")
//    private WebElement newProfile;

    @FindBy(xpath = "//button[@class='create-profile-button button common-primary']")
    private WebElement createProfileButton;

    public CreateProfileLobbyPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreateProfile() {

        waitForElement(driver, createProfileButton).click();
    }
}
