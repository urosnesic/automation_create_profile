package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Utils {

    public static WebElement waitForElement(WebDriver driver, WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        return webElement;
    }

    public static void selectDropdownOption(List<WebElement> options, String value) {

        for (WebElement option: options) {
            if (option.getText().equals(value)) {
                option.click();
            }
        }
    }
}
