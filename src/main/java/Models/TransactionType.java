package Models;

public enum TransactionType {
    Credit,
    Debit;

    public static TransactionType getTransactionType(String type) {
        return type.equals("Credit") ? TransactionType.Credit : TransactionType.Debit;
    }
}
