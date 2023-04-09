import constants.RandomTestUser;
import constants.request.RequestAuthorizationUser;
import constants.request.RequestDeleteUser;
import constants.request.RequestRegistrationUser;
import constants.user.UserAuthorizationFields;
import constants.user.UserRegistrationFields;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static constants.RandomTestUser.EMAIL_USER;
import static constants.RandomTestUser.PASSWORD_USER;
import static constants.request.Header.ACCESS_TOKEN;

public class TestRegistrationUserNegative {
    private WebDriver driver;
    private RegistrationPage objRegistrationPage;

    private UserRegistrationFields userRegistrationFields;
    private RequestDeleteUser requestDeleteUser;
    private RequestRegistrationUser requestRegistrationUser;
    private RequestAuthorizationUser requestAuthorizationUser;
    private String token;

    @Before
    public void startUpChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

//    @Before
//    public void startUpYandex() {
//        ChromeOptions options = new ChromeOptions();
//        System.setProperty("webdriver.chrome.driver", "yandexdriver");
//        options.addArguments("--headless");
//        driver = new ChromeDriver(options);
//    }

    @Before
    public void startUpPage() {
        objRegistrationPage = new RegistrationPage(driver);
        requestDeleteUser = new RequestDeleteUser();
        requestRegistrationUser = new RequestRegistrationUser();
        requestAuthorizationUser = new RequestAuthorizationUser();
        userRegistrationFields = RandomTestUser.getRandomRegistration();
    }

    //    Если этот юзер всё-таки создастся ( то есть тест словит баг), его тоже нужно удалить. Нужно исправить
    @Test
    @DisplayName("Registration user already exists")
    public void checkRegistrationUserAlreadyExists() {
        objRegistrationPage.openRegistration();
        objRegistrationPage.completingRegistrationForm(userRegistrationFields.getEmail(), userRegistrationFields.getName(), userRegistrationFields.getPassword());
        Assert.assertTrue(objRegistrationPage.getRegistrationText());
    }

    @Test
    @DisplayName("Registration user not valid password")
    public void checkRegistrationUserNotValidPassword() {
        objRegistrationPage.openRegistration();
        objRegistrationPage.completingRegistrationForm(userRegistrationFields.getEmail(), userRegistrationFields.getEmail(), PASSWORD_USER);
        Assert.assertTrue(objRegistrationPage.getRegistrationValidateText());
    }

    @Test
    @DisplayName("Registration user not password")
    public void checkRegistrationUserNotPassword() {
        objRegistrationPage.openRegistration();
        objRegistrationPage.completingRegistrationForm(EMAIL_USER, userRegistrationFields.getEmail(), "");
        Assert.assertTrue(objRegistrationPage.getRegistrationText());
    }

    @Test
    @DisplayName("Registration user not name")
    public void checkRegistrationUserNotName() {
        objRegistrationPage.openRegistration();
        objRegistrationPage.completingRegistrationForm(userRegistrationFields.getEmail(), "", userRegistrationFields.getPassword());
        Assert.assertTrue(objRegistrationPage.getRegistrationText());
    }

    @After
    public void quit() {
        token = requestAuthorizationUser.authorizationUser(UserAuthorizationFields.from(userRegistrationFields)).path(ACCESS_TOKEN);
        if (token != null && !token.isBlank()) {
            requestDeleteUser.deleteUser(token);
        }
        driver.quit();
    }
}
