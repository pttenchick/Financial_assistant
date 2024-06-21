package Entity;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Setter
@Getter
public class Transaction {

    private static final Logger logger = LoggerFactory.getLogger(Transaction.class);

    private String name;
    private int amount;
    private int index;

    public Transaction(String nameTransaction, int amount, int index, String groupName) {
        this.name = nameTransaction;
        this.amount = amount;
        this.index = index;

//Транзакция всегда добавляется в группу при создании; A transaction is always added to the group when it is created
        Group group = GroupManager.getOrCreateGroup(groupName);
        group.addTransaction(this);
        logger.info("Новая транзакция {} создана", this.toString());

    }

    public Transaction(Transaction transaction, String groupName) {
        this.name = transaction.getName();
        this.amount = transaction.getAmount();
        this.index = transaction.getIndex();

//Транзакция всегда добавляется в группу при создании; A transaction is always added to the group when it is created
        Group group = GroupManager.getOrCreateGroup(groupName);
        group.addTransaction(this);
        logger.info("Новая транзакция {} создана", this.toString());
    }

    @Override
    public String toString() {
        return "Transaction{" + index + ";" + name + ";" + amount + "}";
    }

}
