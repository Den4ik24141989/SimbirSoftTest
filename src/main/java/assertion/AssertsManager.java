package assertion;

import Models.Transaction;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.List;

public class AssertsManager {
    @Step("Выполнить проверку баланса - должен быть равен {expected}")
    public static void checkBalance(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    @Step("Проверить наличие совершенных транзакций в списке транзакций")
    public static void checkTransaction(List<Transaction> list, Transaction debit, Transaction withdraw) {
        Assert.assertTrue(list.contains(debit));
        Assert.assertTrue(list.contains(withdraw));
    }
}
