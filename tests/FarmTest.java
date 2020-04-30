import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FarmTest {

    @Test
    void updateFarmSize() {
       Farm farm = new Farm(true, FarmType.BASIC);
       farm.updateFarmSize();
    }
}