package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AbstractPage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    protected void clickWebElement(By by) {
        driver.findElement(by).click();
    }

    protected void sendKeysWebElement(By by, String send) {
        driver.findElement(by).sendKeys(send);
    }

    protected String getTextWebElement(By by) {
        return driver.findElement(by).getText();
    }

    protected void selectByVisibleTextWebElement(String text, By by) {
        new Select(driver.findElement(by))
                .selectByVisibleText(text);
    }

    protected void threadSleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
