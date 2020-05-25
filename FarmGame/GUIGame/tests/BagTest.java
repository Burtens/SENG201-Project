import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BagTest {

    @Test
    void itemUpdatesTest() {
        Bag bag = new Bag();
        assertEquals(0, bag.getFoodAmount());
        assertEquals(0, bag.getToyAmount());
        assertEquals(0, bag.getGFertilizerAmount());
        assertEquals(0, bag.getVFertilizerAmount());
        assertEquals(0, bag.getBonemealAmount());
        ArrayList<Seeds> testArrayList = new ArrayList<>();
        assertEquals(testArrayList, bag.getSeeds());
        assertEquals(false, bag.hasHoe());
        bag.setHasHoe(true);
        assertEquals(true, bag.hasHoe());
        bag.updateFoodAmount(5);
        bag.updateToyAmount(5);
        bag.updateGFertilizerAmount(5);
        bag.updateVFertilizerAmount(5);
        bag.updateBonemealAmount(5);
        assertEquals(5, bag.getFoodAmount());
        assertEquals(5, bag.getToyAmount());
        assertEquals(5, bag.getGFertilizerAmount());
        assertEquals(5, bag.getVFertilizerAmount());
        assertEquals(5, bag.getBonemealAmount());
        bag.updateFoodAmount(-6);
        bag.updateToyAmount(-6);
        bag.updateGFertilizerAmount(-6);
        bag.updateVFertilizerAmount(-6);
        bag.updateBonemealAmount(-6);
        assertEquals(0, bag.getFoodAmount());
        assertEquals(0, bag.getToyAmount());
        assertEquals(0, bag.getGFertilizerAmount());
        assertEquals(0, bag.getVFertilizerAmount());
        assertEquals(0, bag.getBonemealAmount());
        Bag.setHasHoe(false);
    }
}
