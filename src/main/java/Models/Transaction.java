package Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class Transaction {
    private LocalDateTime dateTime;
    private String amount;
    private TransactionType type;

    public Transaction(LocalDateTime dateTime, String amount, TransactionType type) {
        this.dateTime = dateTime;
        this.amount = amount;
        this.type = type;
    }

    public Transaction() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(dateTime.getDayOfMonth() + dateTime.getHour(), that.dateTime.getDayOfMonth() + that.dateTime.getHour())
                && Objects.equals(amount, that.amount)
                && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, amount, type);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy h:mm:ss a", Locale.ENGLISH);
        this.dateTime = LocalDateTime.parse(dateTime, formatter);
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "dateTime=" + dateTime +
                ", amount='" + amount + '\'' +
                ", type=" + type +
                '}';
    }
}
