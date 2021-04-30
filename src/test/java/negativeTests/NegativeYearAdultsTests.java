package negativeTests;

import base.BaseTest;
import dataproviders.CreateProfileProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateNewProfilePage;
import pages.CreateProfileLobbyPage;
import pages.LoginPage;

public class NegativeYearAdultsTests extends BaseTest {

    private static final String profileName = "profile name";

    @Test(dataProvider = "year negative",
            dataProviderClass = CreateProfileProvider.class)
    public void negativeYearAdultsTest(String year) {

        LoginPage loginPage = homePage.clickLogin();
        CreateProfileLobbyPage profileLobbyPage = loginPage.loginToProfileLobbyPage();
        CreateNewProfilePage newProfilePage = profileLobbyPage.clickCreateProfile();
        newProfilePage.sendProfileName(profileName);
        newProfilePage.clickAdults();
        newProfilePage.sendInvalidYear(year);

        Assert.assertEquals(newProfilePage.getErrorIncorrectYear().getText(), "Niste pravilno uneli godinu.");
    }
}
