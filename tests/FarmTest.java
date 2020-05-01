import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FarmTest {

    Farm farm = new Farm(true, FarmType.BASIC);

    @Test
    void updateFarmSize() {
       farm.updateFarmSize();
    }

    @Test
    void testplantCrop() {
        Crop carrot = new Carrots(farm);
        farm.plantCrop(carrot);
        boolean isIn = false;
        for (int i = 0; i < farm.plots.length; i++)
        {
            if (farm.plots[i] == carrot) {
                isIn = true;
            }
        }
        assertEquals(true, isIn);
    }

    @Test
    void testHarvestCrop()
    {
        Crop carrot = new Carrots(farm);
        Crop corn = new Corn(farm);
        farm.plantCrop(carrot);
        farm.plantCrop(corn);
        farm.harvestCrop();
    }
}