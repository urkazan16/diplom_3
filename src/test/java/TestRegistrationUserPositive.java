import constants.RandomTestUser;
import constants.request.RequestAuthorizationUser;
import constants.request.RequestDeleteUser;
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

public class TestRegistrationUserPositive {
    private WebDriver driver;
    private AuthorizationPage objAuthorizationPage;
    private RegistrationPage objRegistrationPage;
    private MainPage objMainPage;
    private UserRegistrationFields userRegistrationFields;
    private UserAuthorizationFields userAuthorizationFields;
    private RequestAuthorizationUser requestAuthorizationUser;
    private RequestDeleteUser requestDeleteUser;
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
        requestDeleteUser = new RequestDeleteUser();
        requestAuthorizationUser = new RequestAuthorizationUser();
        userRegistrationFields = RandomTestUser.getRandomRegistration();
        userAuthorizationFields = UserAuthorizationFields.from(userRegistrationFields);
    }

    @Test
    @DisplayName("Registration user")
    public void checkRegistrationUser() {
        objRegistrationPage.openRegistration();
        objRegistrationPage.completingTheRegistrationForm(userRegistrationFields.getEmail(), userRegistrationFields.getName(), userRegistrationFields.getPassword());
        Assert.assertTrue(objAuthorizationPage.getAuthorizationText());
    }


    @After
    public void quit() {
        token = requestAuthorizationUser.authorizationUser(UserAuthorizationFields.from(userRegistrationFields)).path(ACCESS_TOKEN);
        requestDeleteUser.deleteUser(token);
        driver.quit();
    }
}
