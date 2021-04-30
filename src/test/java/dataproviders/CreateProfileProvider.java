package dataproviders;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

import static elementUtils.ElementUtils.randomMaximumInvalidYear;
import static elementUtils.ElementUtils.randomMinimumInvalidYear;

public class CreateProfileProvider {

    private static String nameRegular = RandomStringUtils.random(15, true, false);
    private static String nameAlphanumeric = RandomStringUtils.random(15, true, true);
    private static String nameNumeric = RandomStringUtils.random(15, false, true);

    private static String yearMinNegative = randomMinimumInvalidYear();
    private static String yearMaxNegative = randomMaximumInvalidYear();

    @DataProvider(name = "name positive")
    public static Object[][] profileName() {

        return new Object[][] {
                {nameRegular},
                {nameAlphanumeric},
                {nameNumeric}
        };
    }

    @DataProvider(name = "year negative")
    public static Object[][] yearNegative() {

        return new Object[][] {
                {yearMinNegative},
                {yearMaxNegative}
        };
    }
}
