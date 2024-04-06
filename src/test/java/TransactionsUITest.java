import Models.Transaction;
import Models.TransactionType;
import org.testng.annotations.*;
import utils.csv.CsvWriter;
import utils.allure.AllureHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import static common.Constants.LOGIN;
import static common.Constants.TRANSACTIONS_FILE;


public class TransactionsUITest extends BaseTest {

    @Test
    public void checkingTransactions() throws IOException {
        open(System.getProperty("base_page"));

        loginPage.clickCustomerLogin();

        customerPage.selectYourName(LOGIN).clickSubmit();

        amount = calculateFibonacciNumber();

        Transaction transactionDebit = new Transaction(LocalDateTime.now(), amount, TransactionType.Credit);
        accountPage.makeDeposit(transactionDebit.getAmount());

        Transaction transactionWithdraw = new Transaction(LocalDateTime.now(), amount, TransactionType.Debit);
        accountPage.withdrawDeposit(amount)
                .checkBalance("0");

        accountPage.clickTransactions();

        List<Transaction> transactionList = transactionsPage.getTransactions();
        transactionsPage.checkTransaction(transactionList, transactionDebit, transactionWithdraw);

        CsvWriter.writeTransactionsToCsv(transactionList);

        AllureHelper.attachFileCsv(TRANSACTIONS_FILE, Files.readAllBytes(Paths.get(System.getProperty("csv_file"))));
    }
}
