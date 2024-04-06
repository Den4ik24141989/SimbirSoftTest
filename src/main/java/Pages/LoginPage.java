package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends AbstractPage {
    private final By customerLogin = By.xpath("//button[@ng-click='customer()']");
    private final By bankManagerLogin = By.xpath("//button[@ng-click='manager()']");

    @Step("Выбрать Customer Login")
    public void clickCustomerLogin() {
        clickWebElement(customerLogin);
    }
}
