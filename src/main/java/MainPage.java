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

    public boolean getMainText() {
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
        WebDriverWait elementWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        elementWait.until(ExpectedConditions.visibilityOfElementLocated(waitElement));
    }

    public void isWaitTabDisplayed(By waitElement) {
        WebDriverWait elementWait = new WebDriverWait(driver, Duration.ofSeconds(8));
        elementWait.until(ExpectedConditions.visibilityOfElementLocated(waitElement));
    }

    public boolean getActiveTab() {
        isWaitTabDisplayed(ElementsMainPage.ACTIVE_TAB);
        return driver.findElement(ElementsMainPage.ACTIVE_TAB).isDisplayed();
    }

    public boolean getActiveTabTopping() {
        isWaitTabDisplayed(ElementsMainPage.ACTIVE_TAB_TOPPING);
        return driver.findElement(ElementsMainPage.ACTIVE_TAB_TOPPING).isDisplayed();
    }

    public boolean getActiveTabSauces() {
        isWaitTabDisplayed(ElementsMainPage.ACTIVE_TAB_SAUCES);
        return driver.findElement(ElementsMainPage.ACTIVE_TAB_SAUCES).isDisplayed();
    }

    public boolean getActiveTabRolls() {
        isWaitTabDisplayed(ElementsMainPage.ACTIVE_TAB_ROLLS);
        return driver.findElement(ElementsMainPage.ACTIVE_TAB_ROLLS).isDisplayed();
    }

}
