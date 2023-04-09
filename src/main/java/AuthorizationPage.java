import constants.elementPage.ElementsAuthorizationPage;
import constants.elementPage.ElementsMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorizationPage {
    private WebDriver driver;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openAuthorization() {
        driver.get(ElementsMainPage.URL + "/login");
    }

    public boolean getAuthorizationText() {
        isWaitOrderDisplayed(ElementsAuthorizationPage.TEXT_ENTRANCE);
        return driver.findElement(ElementsAuthorizationPage.TEXT_ENTRANCE).isDisplayed();
    }

    public void isWaitOrderDisplayed(By waitElement) {
        WebDriverWait elementWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        elementWait.until(ExpectedConditions.visibilityOfElementLocated(waitElement));
    }

    public void setEmail(String email) {
        driver.findElement(ElementsAuthorizationPage.EMAIL_AUTH_FIELD).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(ElementsAuthorizationPage.PASSWORD_AUTH_FIELD).sendKeys(password);
    }

    public void clickAuthorizationButton() {
        driver.findElement(ElementsAuthorizationPage.BUTTON_AUTH).click();
    }

    public void completingAuthorizationForm(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickAuthorizationButton();
    }

}
