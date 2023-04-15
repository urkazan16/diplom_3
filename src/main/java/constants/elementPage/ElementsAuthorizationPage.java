package constants.elementPage;

import org.openqa.selenium.By;

public class ElementsAuthorizationPage {

    public static final By TEXT_ENTRANCE = By.xpath(".//h2[text()='Вход']");
    public static final By EMAIL_AUTH_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]//input"); // ???
    public static final By PASSWORD_AUTH_FIELD = By.xpath(".//input[contains(@name, 'Пароль')]");
    public static final By BUTTON_AUTH = By.xpath(".//button[text()='Войти']");
}
