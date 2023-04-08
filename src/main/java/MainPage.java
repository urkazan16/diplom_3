import constants.elementPage.ElementsMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMain() {
        driver.get(ElementsMainPage.URL);
    }

    public boolean getManiText() {
        isWaitPageDisplayed(ElementsMainPage.TEXT_HEADER_MAIN);
        return driver.findElement(ElementsMainPage.TEXT_HEADER_MAIN).isDisplayed();
    }

    public void clickButtonSignIn() {
        driver.findElement(ElementsMainPage.BUTTON_SIGN_IN).click();
    }

    public void clickAuthorizationButtonPersonalArea() {
        driver.findElement(ElementsMainPage.BUTTON_PERSONAL_AREA).click();
    }

    public void clickAuthorizationButtonConstructor() {
        driver.findElement(ElementsMainPage.BUTTON_CONSTRUCTOR).click();
    }

    public void clickLogo() {
        driver.findElement(ElementsMainPage.LOGO).click();
    }

    public void clickTabToppings() {
        driver.findElement(ElementsMainPage.TEXT_TOPPINGS).click();
    }

    public void clickTabSauces() {
        driver.findElement(ElementsMainPage.TEXT_SAUCES).click();
    }

    public void clickTabRolls() {
        driver.findElement(ElementsMainPage.TEXT_ROLLS).click();
    }

    public void isWaitPageDisplayed(By waitElement) {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(waitElement));
    }

    public void isWaitTabDisplayed(By waitElement) {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(waitElement));
    }

    public boolean getActiveTab() {
        isWaitTabDisplayed(ElementsMainPage.ACTIVE_TAB);
        return driver.findElement(ElementsMainPage.ACTIVE_TAB).isDisplayed();
    }

}
