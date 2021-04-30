package negativeTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateNewProfilePage;
import pages.CreateProfileLobbyPage;
import pages.LoginPage;
import pages.StartPage;

public class EmptyInputTests extends BaseTest {

    private String validProfileName = "ime profila";

    @Test
    public void emptyNameFiledTest() {

        LoginPage loginPage = homePage.clickLogin();
        CreateProfileLobbyPage profileLobbyPage = loginPage.loginToProfileLobbyPage();
        CreateNewProfilePage newProfilePage = profileLobbyPage.clickCreateProfile();
        StartPage startPage = newProfilePage.createProfile();

        Assert.assertEquals(newProfilePage.getErrorNoProfileName().getText(), "Niste uneli ime.");
    }

    @Test
    public void noAgeGroupTest() {

        LoginPage loginPage = homePage.clickLogin();
        CreateProfileLobbyPage profileLobbyPage = loginPage.loginToProfileLobbyPage();
        CreateNewProfilePage newProfilePage = profileLobbyPage.clickCreateProfile();
        newProfilePage.sendProfileName(validProfileName);
        StartPage startPage = newProfilePage.createProfile();

        Assert.assertEquals(newProfilePage.getErrorNoAgeGroup().getText(), "Izaberite željenu starosnu grupu da biste kreirali profil.");
    }

    @Test
    public void noAvatarTest() {

        LoginPage loginPage = homePage.clickLogin();
        CreateProfileLobbyPage profileLobbyPage = loginPage.loginToProfileLobbyPage();
        CreateNewProfilePage newProfilePage = profileLobbyPage.clickCreateProfile();
        newProfilePage.sendProfileName(validProfileName);
        newProfilePage.clickTeenager12_14();
        StartPage startPage = newProfilePage.createProfile();

        Assert.assertEquals(newProfilePage.getErrorNoAvatar().getText(), "Izaberite željeni avatar da biste kreirali profil.");
    }

    @Test
    public void noYearTest() {

        LoginPage loginPage = homePage.clickLogin();
        CreateProfileLobbyPage profileLobbyPage = loginPage.loginToProfileLobbyPage();
        CreateNewProfilePage newProfilePage = profileLobbyPage.clickCreateProfile();
        newProfilePage.sendProfileName(validProfileName);
        newProfilePage.clickAdults();
        StartPage startPage = newProfilePage.createProfile();

        Assert.assertEquals(newProfilePage.getErrorIncorrectYear().getText(), "Niste pravilno uneli godinu.");
    }

    @Test
    public void noInputsAllTest() {

        LoginPage loginPage = homePage.clickLogin();
        CreateProfileLobbyPage profileLobbyPage = loginPage.loginToProfileLobbyPage();
        CreateNewProfilePage newProfilePage = profileLobbyPage.clickCreateProfile();
        StartPage startPage = newProfilePage.createProfile();

        Assert.assertEquals(newProfilePage.getErrorNoProfileName().getText(), "Niste uneli ime.");
        Assert.assertEquals(newProfilePage.getErrorNoAgeGroup().getText(), "Izaberite željenu starosnu grupu da biste kreirali profil.");
        Assert.assertEquals(newProfilePage.getErrorNoAvatar().getText(), "Izaberite željeni avatar da biste kreirali profil.");
    }
}
