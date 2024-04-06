package utils.csv;

import Models.Transaction;
import io.qameta.allure.Step;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class CsvWriter {
    @Step("Сформировать файл формата csv о проведенных операциях")
    public static void writeTransactionsToCsv(List<Transaction> transactions) {
        try (FileWriter writer = new FileWriter(System.getProperty("csv_file"))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss");
            String firstLine = "Date-Time, Amount, Transaction Type\n";
            writer.write(firstLine);
            for (Transaction transaction : transactions) {
                String formattedDateTime = transaction.getDateTime().format(formatter);
                String line = String.format("%s, %s, %s%n", formattedDateTime, transaction.getAmount(), transaction.getType());
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
