package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage extends AbstractPage {
    private final By yourName = By.xpath("//select[@id='userSelect']");

    private final By submit = By.xpath("//button[@type='submit']");

    @Step("Авторизоваться пользователем «{name}»")
    public CustomerPage selectYourName(String name) {
        new Select(driver.findElement(yourName))
                .selectByVisibleText(name);
        return this;
    }

    public void clickSubmit() {
        clickWebElement(submit);
    }
}
