package elementUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class ElementUtils {

    private static final int maxValidYear = 2003;
    private static final int minValidYear = 1900;

    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        return webElement;
    }

    public static Boolean waitForInvisibility(WebDriver driver, By element) {

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        Boolean invisible =  wait.until((ExpectedConditions.invisibilityOfElementLocated(element)));
        return invisible;
    }

    public static void selectDropdownOption(List<WebElement> options, String value) {

        for (WebElement option: options) {
            if (option.getText().equals(value)) {
                option.click();
            }
        }
    }

    public static void clickRandomElement(List<WebElement> elements) {

        Random random = new Random();
        elements.get(random.nextInt(elements.size())).click();
    }

    public static String randomValidYear() {

        Integer validYear = (int)(Math.random()*(maxValidYear - minValidYear + 1) + minValidYear);
        return validYear.toString();
    }

    public static String randomMinimumInvalidYear() {

        Integer minInvalidYear = (int)(Math.random()*(1899 - 1000) + 1000);
        return minInvalidYear.toString();
    }

    public static String randomMaximumInvalidYear() {

        Integer maxInvalidYear = (int)(Math.random()*(9999 - 2003 + 1) + 2003);
        return maxInvalidYear.toString();
    }
}
