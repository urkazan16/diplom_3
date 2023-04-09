package constants.elementPage;

import org.openqa.selenium.By;

public class ElementsRegistrationPage {
    public static final By NAME_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    public static final By EMAIL_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    public static final By PASSWORD_FIELD = By.xpath(".//input[contains(@name, 'Пароль')]");
    public static final By BUTTON_SIGN_IN = By.xpath(".//a[text()='Войти']");
    public static final By BUTTON_REGISTER = By.xpath(".//button[text()='Зарегистрироваться']");
    public static final By TEXT_REGISTER = By.xpath(".//h2[text()='Регистрация']");
    public static final By INCORRECT_PASSWORD = By.xpath(".//p[text()='Некорректный пароль']");
}
