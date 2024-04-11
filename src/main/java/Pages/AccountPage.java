package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AccountPage extends AbstractPage {
    private final By transactions = By.xpath("//button[@ng-click='transactions()']");
    private final By deposit = By.xpath("//button[@ng-click='deposit()']");
    private final By withdrawal = By.xpath("//button[@ng-click='withdrawl()']");
    private final By inputDepositedAmount = By.xpath("//label[text()='Amount to be Deposited :']/following-sibling::input");
    private final By inputWithdrawnAmount = By.xpath("//label[text()='Amount to be Withdrawn :']/following-sibling::input");
    private final By btnSubmitWithdraw = By.xpath("//button[@type='submit' and text()='Withdraw']");
    private final By btnSubmitDeposit = By.xpath("//button[@type='submit' and text()='Deposit']");
    private final By balance = By.xpath("(//div[@class='center'])[1]/child::strong[2]");

    @Step("Открыть страницу транзакций")
    public void clickTransactions() {
        clickWebElement(transactions);
    }

    @Step("Выполнить пополнение счета на сумму равную вычисленному числу Фибоначчи дня месяца")
    public AccountPage makeDeposit(String amount) {
        clickWebElement(deposit);
        sendKeysWebElement(inputDepositedAmount, amount);
        clickWebElement(btnSubmitDeposit);
        threadSleep(1000);
        return this;
    }

    @Step("Выполнить списание со счета равному пополнению")
    public AccountPage withdrawDeposit(String amount) {
        clickWebElement(withdrawal);
        sendKeysWebElement(inputWithdrawnAmount, amount);
        clickWebElement(btnSubmitWithdraw);
        threadSleep(1000);
        return this;
    }

    public String getBalance() {
        return getTextWebElement(balance);
    }
}
