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

public class TestLogoutUser {
    private WebDriver driver;
    private AuthorizationPage objAuthorizationPage;
    private RegistrationPage objRegistrationPage;
    private PersonalAreaPage objPersonalAreaPage;
    private MainPage objMainPage;
    private RequestDeleteUser requestDeleteUser;
    private UserAuthorizationFields userAuthorizationFields;
    private UserRegistrationFields userRegistrationFields;
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
        objPersonalAreaPage = new PersonalAreaPage(driver);
        requestDeleteUser = new RequestDeleteUser();
        requestRegistrationUser = new RequestRegistrationUser();
        userRegistrationFields = RandomTestUser.getRandomRegistration();
        userAuthorizationFields = UserAuthorizationFields.from(userRegistrationFields);
        token = requestRegistrationUser.registerUser(userRegistrationFields).path(ACCESS_TOKEN);
        objMainPage.openMain();
        objMainPage.clickButtonSignIn();
        objAuthorizationPage.completingAuthorizationForm(userAuthorizationFields.getEmail(), userAuthorizationFields.getPassword());
        objMainPage.getMainText();
    }

    @Test
    @DisplayName("Click personal area auth user")
    public void checkClickPersonalAreaAuthUser() {
        objMainPage.clickAuthorizationButtonPersonalArea();
        objPersonalAreaPage.clickLogout();
        Assert.assertTrue(objAuthorizationPage.getAuthorizationText());
    }

    @After
    public void quit() {
        if (token != null && !token.isBlank()) {
            requestDeleteUser.deleteUser(token);
        }
        driver.quit();
    }
}