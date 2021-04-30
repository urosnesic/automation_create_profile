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
    }
}