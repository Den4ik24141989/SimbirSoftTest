package Pages;

import Models.Transaction;
import Models.TransactionType;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class TransactionsPage extends AbstractPage {
    private final By transactions = By.xpath("//table/tbody/tr");

    public TransactionsPage() {}

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

    @Step("Проверить наличие совершенных транзакций в списке транзакций")
    public void checkTransaction(List<Transaction> list, Transaction debit, Transaction withdraw){
        Assert.assertTrue(list.contains(debit));
        Assert.assertTrue(list.contains(withdraw));
    }
}
