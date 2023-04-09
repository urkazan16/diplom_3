import constants.elementPage.ElementsPersonalAreaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAreaPage {
    private final WebDriver driver;

    public PersonalAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean getPersonalAreaText() {
        isWaitOrderDisplayed(ElementsPersonalAreaPage.TEXT_AREA_PAGE);
        return driver.findElement(ElementsPersonalAreaPage.TEXT_AREA_PAGE).isDisplayed();
    }

    public void clickLogout() {
        isWaitOrderDisplayed(ElementsPersonalAreaPage.BUTTON_LOGOUT);
        driver.findElement(ElementsPersonalAreaPage.BUTTON_LOGOUT).click();
    }

    public void isWaitOrderDisplayed(By waitElement) {
        WebDriverWait elementWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        elementWait.until(ExpectedConditions.visibilityOfElementLocated(waitElement));
    }
}
