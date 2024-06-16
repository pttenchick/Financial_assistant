package Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Transaction {

    private String name;
    private int amount;
    private int index;

    public Transaction(String nameTransaction, int amount, int index) {
        this.name = nameTransaction;
        this.amount = amount;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Transaction{" + index + ";" + name + ";" + amount + "}";
    }
    
}
