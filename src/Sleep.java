import java.util.Random;

public class Sleep {

    private int eventChance;

    private void setEventChance() {
        Random randomGen = new Random();
        eventChance = randomGen.nextInt(100);
    }

    public int getEventChance() {
        return eventChance;
    }
}
