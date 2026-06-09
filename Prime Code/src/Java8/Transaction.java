package Java8;

public class Transaction {
    private String  category;
    private  int amount;

    public Transaction(String category, int amount) {
        this.category = category;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
