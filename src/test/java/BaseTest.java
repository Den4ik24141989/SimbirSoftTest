import Pages.*;
import io.qameta.allure.Step;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static common.Constants.IMPLICITLY_WAIT;

public class BaseTest {
    protected String amount;
    protected WebDriver driver;
    protected LoginPage loginPage = new LoginPage();
    protected CustomerPage customerPage = new CustomerPage();
    protected AccountPage accountPage = new AccountPage();
    protected TransactionsPage transactionsPage = new TransactionsPage();


    @BeforeSuite
    public void before() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        setupDriver();
    }
    @Step("Создать экземпляр драйвера")
    private void setupDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WIN10);
        capabilities.setBrowserName("chrome");

        driver = new RemoteWebDriver(new URL( "http://localhost:4444"), capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
        AbstractPage.setDriver(driver);
    }

    @Step("Открыть страницу в браузере")
    public void open(String url) {
        driver.get(url);
    }

    @Step("Вычислить N-е число Фибоначчи, где N - это текущий день месяца")
    protected String calculateFibonacciNumber() {
        int n = LocalDateTime.now().getDayOfMonth();
        int[] fi = new int[n + 1];
        fi[0] = 0;
        fi[1] = 1;
        for(int i = 2; i <= n; i++) {
            fi[i] = fi[i-1] + fi[i-2];
        }
        return String.valueOf(fi[n]);
    }

    @AfterSuite
    public void after() {
        driver.quit();
    }
}
