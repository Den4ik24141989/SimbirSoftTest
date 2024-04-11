package Pages;

import Models.Transaction;
import Models.TransactionType;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TransactionsPage extends AbstractPage {
    private final By transactions = By.xpath("//table/tbody/tr");

    @Step("Получить список транзакций")
    public List <Transaction> getTransactions() {
        List<Transaction> transactionList = new ArrayList<>();
        driver.findElements(transactions).forEach(element -> {
            WebElement dateTime = element.findElement(By.xpath(".//td[1]"));
            WebElement amount = element.findElement(By.xpath(".//td[2]"));
            WebElement transactionType = element.findElement(By.xpath(".//td[3]"));
            Transaction transaction = new Transaction();
            transaction.setDateTime(dateTime.getText());
            transaction.setAmount(amount.getText());
            transaction.setType(TransactionType.getTransactionType(transactionType.getText()));
            transactionList.add(transaction);
        });
        return transactionList;
    }
}
