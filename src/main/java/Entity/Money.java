package Entity;

public class Money {

    private String name;
    private int sum;
    private int index;

    public Money(String nameTransaction, int sum, int index) {
        this.name = nameTransaction;
        this.sum = sum;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }

    public int getIndex() {
        return index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
