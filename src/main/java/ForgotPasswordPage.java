import constants.elementPage.ElementsMainPage;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openForgotPassword() {
        driver.get(ElementsMainPage.URL + "/forgot-password");
    }
}
