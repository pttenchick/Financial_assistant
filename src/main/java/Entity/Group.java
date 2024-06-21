package Entity;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;

@Getter
@Setter
//Класс, группирующий транзакции; A class that groups transactions
public class Group {
    private String name;
    ArrayList<Transaction> group;

    private static final Logger logger = LoggerFactory.getLogger(Group.class);

    public Group(String name) {
        this.name = name;
        this.group = new ArrayList<>();
    }

    //Добавление транзакции в группу; Adding a transaction to a group
    public void addTransaction(Transaction transaction) {
        if (transaction == null) {
            logger.error("Попытка добавить null транзакцию");
            throw new IllegalArgumentException("Транзакция не может быть null");
        }
        group.add(transaction);
        logger.info("Транзакция добавлена: {}", transaction);
    }
//Удаление транзакции из группы; Remove a transaction to group
    public void removeTransaction(Transaction transaction) {
        if (transaction == null) {
            logger.error("Попытка удалить null транзакцию");
            throw new IllegalArgumentException("Транзакция не может быть null");
        }
        boolean isRemoved = group.remove(transaction);
        if (isRemoved) {
            logger.info("Транзакция удалена: {}", transaction);
        } else {
            logger.warn("Транзакция не найдена при попытке удаления: {}", transaction);
        }
    }
//Получение транзакции по номеру; Get a transaction via index
    public Transaction getTransaction(int index){

        for (Transaction trs : group) {
            if (trs.getIndex() == index) {
                logger.debug("Транзакция найдена: {}", trs);
                return trs;
            }
        }

        logger.warn("Транзакция с индексом {} не найдена.", index);
        return null;
    }
}
