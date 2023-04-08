import constants.elementPage.ElementsMainPage;
import constants.elementPage.ElementsRegistrationPage;
import constants.user.UserRegistrationFields;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RegistrationPage {
    private final WebDriver driver;
    private UserRegistrationFields userRegistrationFields;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openRegistration() {
        driver.get(ElementsMainPage.URL + "/register");
    }

    public void setEmail(String email) {
        driver.findElement(ElementsRegistrationPage.EMAIL_FIELD).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(ElementsRegistrationPage.PASSWORD_FIELD).sendKeys(password);
    }

    public void setName(String name) {
        driver.findElement(ElementsRegistrationPage.NAME_FIELD).sendKeys(name);
    }

    public void clickRegistrationButton() {
        driver.findElement(ElementsRegistrationPage.BUTTON_REGISTER).click();
    }

    public void clickRegistrationButtonSignIn() {
        driver.findElement(ElementsRegistrationPage.BUTTON_SIGN_IN).click();
    }

    public boolean getRegistrationValidateText() {
        isWaitOrderDisplayed(ElementsRegistrationPage.INCORRECT_PASSWORD);
        return driver.findElement(ElementsRegistrationPage.INCORRECT_PASSWORD).isDisplayed();
    }

    public boolean getRegistrationText() {
        isWaitOrderDisplayed(ElementsRegistrationPage.TEXT_REGISTER);
        return driver.findElement(ElementsRegistrationPage.TEXT_REGISTER).isDisplayed();
    }

    public void isWaitOrderDisplayed(By waitElement) {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(waitElement));
    }

    public void completingTheRegistrationForm(String email, String name, String password) {
        setEmail(email);
        setName(name);
        setPassword(password);
        clickRegistrationButton();
    }

}
