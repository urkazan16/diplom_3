import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TestConstructor {
    private WebDriver driver;
    private MainPage objMainPage;

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
    }


    @Test
    @DisplayName("Constructor tab rolls")
    public void checkConstructorTabRolls() {
        objMainPage.openMain();
        objMainPage.clickTabToppings();
        objMainPage.clickTabRolls();
        Assert.assertTrue(objMainPage.getActiveTabRolls());
    }

    @Test
    @DisplayName("Constructor tab sauces")
    public void checkConstructorTabSauces() {
        objMainPage.openMain();
        objMainPage.clickTabSauces();
        Assert.assertTrue(objMainPage.getActiveTabSauces());

    }

    @Test
    @DisplayName("Constructor tab toppings")
    public void checkConstructorTabToppings() {
        objMainPage.openMain();
        objMainPage.clickTabToppings();
        Assert.assertTrue(objMainPage.getActiveTabTopping());
    }

    @After
    public void quit() {
        driver.quit();
    }
}
