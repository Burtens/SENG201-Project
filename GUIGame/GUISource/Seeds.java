public class Seeds {

    private String type;
    private int amount;

    Seeds(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    /*when setting amount if this seed is not in list of seeds add it to list of seeds*/
    public void updateAmount(int num) {
        this.amount += num;
        if (this.amount < 0)
            this.amount = 0;
    }

    public int getAmount() { return this.amount; }

    public String toString() { return this.type; }
}
