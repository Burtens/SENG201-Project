import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

public class StatusTest {

    @Test
    void statusTest() {
        Status status = new Status();
        assertEquals(500, status.getMoney());
        assertEquals(1, status.getDay());
        assertEquals(2, status.getActions());
        status.updateMoney(100);
        assertEquals(600, status.getMoney());
        status.updateMoney(-700);
        assertEquals(0, status.getMoney());
        status.updateActions(-1);
        assertEquals(1, status.getActions());
        status.updateActions(2);
        assertEquals(2, status.getActions());
        status.updateActions(-3);
        assertEquals(0, status.getActions());
    }


    @Test
    void updateDayTest() {
        Status status = new Status();
        Farm farm = new Farm();
        farm.newAnimal(new Cow());
        farm.setFarmType(FarmType.BASIC);
        Bag.updateSeeds("Potatoes", 1);
        farm.plantCrop("Potatoes", 0, 0);
        status.updateActions(-2);
        status.updateDay(farm);
        assertEquals(90, farm.getPens()[0].getHealth());
        assertEquals(85, farm.getPens()[0].getHappiness());
        assertEquals(25, farm.getPlots()[0].getGrowth());
        assertEquals(2, status.getActions());
        farm.setTended(true);
        status.updateDay(farm);
        assertEquals(85, farm.getPens()[0].getHappiness());
        assertEquals(false, farm.getTended());
        farm.getPens()[0].play();
        farm.setFarmType(FarmType.MEADOW);
        status.updateDay(farm);
        assertEquals(90, farm.getPens()[0].getHappiness());
        farm.getPens()[0].play();
        farm.setFarmType(FarmType.BARRON);
        status.updateDay(farm);
        assertEquals(70, farm.getPens()[0].getHappiness());
    }
}
