package constants.elementPage;

import org.openqa.selenium.By;

public class ElementsMainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site";
    public static final By BUTTON_SIGN_IN = By.xpath(".//button[text()='Войти в аккаунт']");
    public static final By TEXT_HEADER_MAIN = By.xpath(".//h1[text()='Соберите бургер']");
    public static final By BUTTON_PERSONAL_AREA = By.xpath(".//p[text()='Личный Кабинет']");
    public static final By BUTTON_CONSTRUCTOR = By.xpath(".//p[text()='Конструктор']");
    public static final By LOGO = By.xpath(".//div/a[@aria-current='page']");
    public static final By TEXT_TOPPINGS = By.xpath(".//span[@class = 'text text_type_main-default' and text()='Начинки']/parent::div");
    public static final By TEXT_SAUCES = By.xpath(".//span[@class = 'text text_type_main-default' and text()='Соусы']/parent::div");
    public static final By TEXT_ROLLS = By.xpath(".//span[@class = 'text text_type_main-default' and text()='Булки']/parent::div");
    public static final By ACTIVE_TAB = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span");
}
