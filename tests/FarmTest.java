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
    void plantCrop() {
        Crop carrot = new Carrots(farm);
        farm.plant(carrot);
        boolean isIn = false;
        for (int i = 0; i < farm.plots.length; i++)
        {
            if (farm.plots[i] == carrot) {
                isIn = true;
            }
        }
        assertEquals(true, isIn);
    }
}