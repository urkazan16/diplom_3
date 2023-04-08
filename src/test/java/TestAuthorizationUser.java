import constants.RandomTestUser;
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

import static constants.request.Header.ACCESS_TOKEN;

public class TestAuthorizationUser {
    private WebDriver driver;
    private AuthorizationPage objAuthorizationPage;
    private RegistrationPage objRegistrationPage;
    private ForgotPasswordPage objForgotPasswordPage;
    private UserAuthorizationFields userAuthorizationFields;
    private UserRegistrationFields userRegistrationFields;
    private MainPage objMainPage;
    private RequestDeleteUser requestDeleteUser;
    private RequestRegistrationUser requestRegistrationUser;
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
        objMainPage = new MainPage(driver);
        objAuthorizationPage = new AuthorizationPage(driver);
        objRegistrationPage = new RegistrationPage(driver);
        objForgotPasswordPage = new ForgotPasswordPage(driver);
        requestDeleteUser = new RequestDeleteUser();
        requestRegistrationUser = new RequestRegistrationUser();
        userRegistrationFields = RandomTestUser.getRandomRegistration();
        userAuthorizationFields = UserAuthorizationFields.from(userRegistrationFields);
        token = requestRegistrationUser.registerUser(userRegistrationFields).path(ACCESS_TOKEN);
    }


    @Test
    @DisplayName("Authorization user")
    public void checkAuthorizationUser() {
        objAuthorizationPage.openAuthorization();
        objAuthorizationPage.completingTheAuthorizationForm(userAuthorizationFields.getEmail(), userAuthorizationFields.getPassword());
        Assert.assertTrue(objMainPage.getManiText());
    }

    @Test
    @DisplayName("Authorization user button sign in")
    public void checkAuthorizationUserButtonSignIn() {
        objMainPage.openMain();
        objMainPage.clickButtonSignIn();
        objAuthorizationPage.completingTheAuthorizationForm(userAuthorizationFields.getEmail(), userAuthorizationFields.getPassword());
        Assert.assertTrue(objMainPage.getManiText());
    }

    @Test
    @DisplayName("Authorization user button personal area")
    public void checkAuthorizationUserButtonPersonalArea() {
        objMainPage.openMain();
        objMainPage.clickAuthorizationButtonPersonalArea();
        objAuthorizationPage.completingTheAuthorizationForm(userAuthorizationFields.getEmail(), userAuthorizationFields.getPassword());
        Assert.assertTrue(objMainPage.getManiText());
    }

    @Test
    @DisplayName("Authorization user registration form")
    public void checkAuthorizationUserRegistrationForm() {
        objRegistrationPage.openRegistration();
        objRegistrationPage.clickRegistrationButtonSignIn();
        objAuthorizationPage.completingTheAuthorizationForm(userAuthorizationFields.getEmail(), userAuthorizationFields.getPassword());
        Assert.assertTrue(objMainPage.getManiText());
    }

    @Test
    @DisplayName("Authorization user forgot password form")
    public void checkAuthorizationUserForgotPasswordForm() {
        objForgotPasswordPage.openForgotPassword();
        objRegistrationPage.clickRegistrationButtonSignIn();
        objAuthorizationPage.completingTheAuthorizationForm(userAuthorizationFields.getEmail(), userAuthorizationFields.getPassword());
        Assert.assertTrue(objMainPage.getManiText());
    }


    @After
    public void quit() {
        requestDeleteUser.deleteUser(token);
        driver.quit();
    }
}
