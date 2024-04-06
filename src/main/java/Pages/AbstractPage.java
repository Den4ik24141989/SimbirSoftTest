package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AbstractPage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public void clickWebElement(By by) {
        driver.findElement(by).click();
    }

    public void sendKeysWebElement(By by, String send) {
        driver.findElement(by).sendKeys(send);
    }

    public void threadSleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
