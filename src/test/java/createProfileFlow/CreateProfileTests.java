package createProfileFlow;

import base.BaseTest;
import dataproviders.CreateProfileProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateNewProfilePage;
import pages.CreateProfileLobbyPage;
import pages.LoginPage;
import pages.StartPage;

public class CreateProfileTests extends BaseTest {

    @Test(dataProvider = "name positive",
            dataProviderClass = CreateProfileProvider.class)
    public void createProfileTeenager12_14(String name) {

        LoginPage loginPage = homePage.clickLogin();
        CreateProfileLobbyPage profileLobbyPage = loginPage.loginToProfileLobbyPage();
        CreateNewProfilePage newProfilePage = profileLobbyPage.clickCreateProfile();
        newProfilePage.sendProfileName(name);
        newProfilePage.clickTeenager12_14();
        newProfilePage.pickAvatar();
        newProfilePage.pickBackground();

        StartPage startPage = newProfilePage.createProfile();
        startPage.waitInvisibility();
        startPage.clickOk();
        startPage.clickSettings();
        startPage.clickMyProfile();

        Assert.assertEquals(startPage.getFieldWithProfileName().getAttribute("value"), name);

        /*
            TODO
            Two lines after assert are for deleting profile that was created by test.
            This is not a good solution, there should be no lines of code after assert.
            Much better solution would be that every test has its own unique login credentials (that is, every test would use new account).
            Alternatively, we could use api call to DELETE profile end point (if new account per test is not an option),
            but I was unable to figure out how to make it work without documentation.

            This applies to all tests in this class.
         */

        startPage.clickDeleteProfileButton();
        startPage.clickConfirmDelete();
    }

    @Test(dataProvider = "name positive",
            dataProviderClass = CreateProfileProvider.class)
    public void createProfileTeenager15_17(String name) {

        LoginPage loginPage = homePage.clickLogin();
        CreateProfileLobbyPage profileLobbyPage = loginPage.loginToProfileLobbyPage();
        CreateNewProfilePage newProfilePage = profileLobbyPage.clickCreateProfile();
        newProfilePage.sendProfileName(name);
        newProfilePage.clickTeenager15_17();
        newProfilePage.pickAvatar();
        newProfilePage.pickBackground();

        StartPage startPage = newProfilePage.createProfile();
        startPage.waitInvisibility();
        startPage.clickOk();
        startPage.clickSettings();
        startPage.clickMyProfile();

        Assert.assertEquals(startPage.getFieldWithProfileName().getAttribute("value"), name);

        startPage.clickDeleteProfileButton();
        startPage.clickConfirmDelete();
    }

    @Test(dataProvider = "name positive",
            dataProviderClass = CreateProfileProvider.class)
    public void createProfileAdults(String name) {

        LoginPage loginPage = homePage.clickLogin();
        CreateProfileLobbyPage profileLobbyPage = loginPage.loginToProfileLobbyPage();
        CreateNewProfilePage newProfilePage = profileLobbyPage.clickCreateProfile();
        newProfilePage.sendProfileName(name);
        newProfilePage.clickAdults();
        newProfilePage.sendValidYear();
        newProfilePage.pickAvatar();
        newProfilePage.pickBackground();

        StartPage startPage = newProfilePage.createProfile();
        startPage.waitInvisibility();
        startPage.clickOk();
        startPage.clickSettings();
        startPage.clickMyProfile();

        Assert.assertEquals(startPage.getFieldWithProfileName().getAttribute("value"), name);

        startPage.clickDeleteProfileButton();
        startPage.clickConfirmDelete();
    }

    @Test(dataProvider = "name positive",
            dataProviderClass = CreateProfileProvider.class)
    public void createProfileChildren0_6(String name) {

        LoginPage loginPage = homePage.clickLogin();
        CreateProfileLobbyPage profileLobbyPage = loginPage.loginToProfileLobbyPage();
        CreateNewProfilePage newProfilePage = profileLobbyPage.clickCreateProfile();
        newProfilePage.sendProfileName(name);
        newProfilePage.clickChildren0_6();
        newProfilePage.pickAvatarChildren();
        newProfilePage.clickPinCheckBox();
        newProfilePage.sendPinCode();
        newProfilePage.clickPinConfirm();

        StartPage startPage = newProfilePage.createProfile();
        startPage.waitInvisibility();
        startPage.clickOk();
        startPage.clickSettings();

        Assert.assertEquals(startPage.getFieldWithProfileName().getAttribute("value"), name);

        startPage.clickOtherSettings();
        startPage.sendPinInput();
        startPage.clickConfirmPin();
        startPage.clickDeleteChildProfile();
        startPage.clickConfirmDelete();
    }

    @Test(dataProvider = "name positive",
            dataProviderClass = CreateProfileProvider.class)
    public void createProfileChildren7_11(String name) {

        LoginPage loginPage = homePage.clickLogin();
        CreateProfileLobbyPage profileLobbyPage = loginPage.loginToProfileLobbyPage();
        CreateNewProfilePage newProfilePage = profileLobbyPage.clickCreateProfile();
        newProfilePage.sendProfileName(name);
        newProfilePage.clickChildren7_11();
        newProfilePage.pickAvatarChildren();
        newProfilePage.clickPinCheckBox();
        newProfilePage.sendPinCode();
        newProfilePage.clickPinConfirm();

        StartPage startPage = newProfilePage.createProfile();
        startPage.waitInvisibility();
        startPage.clickOk();
        startPage.clickSettings();

        Assert.assertEquals(startPage.getFieldWithProfileName().getAttribute("value"), name);

        startPage.clickOtherSettings();
        startPage.sendPinInput();
        startPage.clickConfirmPin();
        startPage.clickDeleteChildProfile();
        startPage.clickConfirmDelete();
    }
}
