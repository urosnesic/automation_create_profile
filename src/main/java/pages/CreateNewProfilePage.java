package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static elementUtils.ElementUtils.*;

public class CreateNewProfilePage {

    private WebDriver driver;
    public static final String PIN = "0000";

    @FindBy(xpath = "//img[@alt='Avatar image']")
    private List<WebElement> avatars;

    @FindBy(xpath = "//input[@maxlength='32']")
    private WebElement profileName;

    @FindBy(xpath = "//span[contains(text(),'0-6')]")
    private WebElement children0_6;

    @FindBy(xpath = "//span[contains(text(),'7-11')]")
    private WebElement children7_11;

    @FindBy(xpath = "//span[contains(text(),'12-14')]")
    private WebElement teenager12_14;

    @FindBy(xpath = "//span[contains(text(),'15-17')]")
    private WebElement teenager15_17;

    @FindBy(xpath = "//span[contains(text(),'18+')]")
    private WebElement adults;

    @FindBy(xpath = "//input[@maxlength='4']")
    private WebElement yearOfBirthField;

    @FindBy(className = "tet")
    private List<WebElement> backgroundLight;

    @FindBy(xpath = "//button[contains(text(), 'Kreiraj profil')]")
    private WebElement createProfileButton;

    @FindBy(className = "checkbox-switch")
    private WebElement pinCheckBox;

    @FindBy(xpath = "//input[@maxlength='4']")
    private WebElement pinCode;

    @FindBy(xpath = "//button[contains(text(), 'Potvrdi')]")
    private WebElement pinConfirm;

    @FindBy(xpath = "//span[@class='error']")
    private WebElement errorNoProfileName;

    @FindBy(xpath = "//p[contains(text(), 'Izaberite željenu starosnu grupu da biste kreirali profil.')]")
    private WebElement errorNoAgeGroup;

    @FindBy(xpath = "//p[contains(text(), 'Izaberite željeni avatar da biste kreirali profil.')]")
    private WebElement errorNoAvatar;

    @FindBy(xpath = "//span[contains(text(), 'Niste pravilno uneli godinu.')]")
    private WebElement errorIncorrectYear;

    private List<WebElement> avatarsChildren;

    public CreateNewProfilePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendProfileName(String name) {

        profileName.sendKeys(name);
    }

    public void clickChildren0_6() {

        waitForElementToBeClickable(driver, children0_6).click();
    }

    public void clickChildren7_11() {

        waitForElementToBeClickable(driver, children7_11).click();
    }

    public void clickTeenager12_14() {

        waitForElementToBeClickable(driver, teenager12_14).click();
    }

    public void clickTeenager15_17() {

        waitForElementToBeClickable(driver, teenager15_17).click();
    }

    public void clickAdults() {

        waitForElementToBeClickable(driver, adults).click();
    }

    public void pickAvatar() {

        clickRandomElement(avatars);
    }

    public void pickAvatarChildren() {

        if (avatars.size() > 6) {
            avatarsChildren = driver.findElements(By.xpath("//img[@alt='Avatar image']"));
        }

        clickRandomElement(driver.findElements(By.xpath("//img[@alt='Avatar image']")));
    }

    public void sendValidYear() {

        yearOfBirthField.sendKeys(randomValidYear());
    }

    public void sendInvalidYear(String year) {

        yearOfBirthField.sendKeys(year);
    }

    public void pickBackground() {

        clickRandomElement(backgroundLight);
    }

    public List<WebElement> getAvatars() {

        return avatars;
    }

    public void clickPinCheckBox() {

        pinCheckBox.click();
    }

    public void sendPinCode() {

        pinCode.sendKeys(PIN);
    }

    public void clickPinConfirm() {

        pinConfirm.click();
    }

    public WebElement getErrorNoProfileName() {

        return errorNoProfileName;
    }

    public WebElement getErrorNoAgeGroup() {

        return errorNoAgeGroup;
    }

    public WebElement getErrorNoAvatar() {

        return errorNoAvatar;
    }

    public WebElement getErrorIncorrectYear() {

        return errorIncorrectYear;
    }

    public StartPage createProfile() {

        createProfileButton.click();
        return new StartPage(driver);
    }
}
