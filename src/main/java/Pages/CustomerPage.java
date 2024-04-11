package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CustomerPage extends AbstractPage {
    private final By yourName = By.xpath("//select[@id='userSelect']");
    private final By submit = By.xpath("//button[@type='submit']");

    @Step("Авторизоваться пользователем «{name}»")
    public CustomerPage selectYourName(String name) {
        selectByVisibleTextWebElement(name, yourName);
        return this;
    }

    public void clickSubmit() {
        clickWebElement(submit);
    }
}
