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

public class TestPersonalAreaPage {
    private WebDriver driver;
    private AuthorizationPage objAuthorizationPage;
    private RegistrationPage objRegistrationPage;
    private PersonalAreaPage objPersonalAreaPage;
    private MainPage objMainPage;
    private UserAuthorizationFields userAuthorizationFields;
    private UserRegistrationFields userRegistrationFields;
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
        objPersonalAreaPage = new PersonalAreaPage(driver);
        requestDeleteUser = new RequestDeleteUser();
        requestRegistrationUser = new RequestRegistrationUser();
        userRegistrationFields = RandomTestUser.getRandomRegistration();
        userAuthorizationFields = UserAuthorizationFields.from(userRegistrationFields);
        token = requestRegistrationUser.registerUser(userRegistrationFields).path(ACCESS_TOKEN);
        objMainPage.openMain();
        objMainPage.clickButtonSignIn();
        objAuthorizationPage.completeAuthorizationForm(userAuthorizationFields.getEmail(), userAuthorizationFields.getPassword());
        objMainPage.getMainText();
    }

    @Test
    @DisplayName("Click personal area auth user")
    public void checkClickPersonalAreaAuthUser() {
        objMainPage.openMain();
        objMainPage.clickAuthorizationButtonPersonalArea();
        Assert.assertTrue(objPersonalAreaPage.getPersonalAreaText());
    }

    @Test
    @DisplayName("Click constructor auth user")
    public void checkClickConstructorAuthUser() {
        objMainPage.openMain();
        objMainPage.clickAuthorizationButtonConstructor();
        Assert.assertTrue(objMainPage.getMainText());
    }

    @Test
    @DisplayName("Click logo auth user")
    public void checkClickLogoAuthUser() {
        objMainPage.openMain();
        objMainPage.clickLogo();
        Assert.assertTrue(objMainPage.getMainText());
    }

    @After
    public void quit() {
        if (token != null && !token.isBlank()) {
            requestDeleteUser.deleteUser(token);
        }
        driver.quit();
    }
}
