import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FarmTest {

    Farm farm = new Farm(true, FarmType.BASIC, null);

    @Test
    void updateFarmSize() {
       farm.updatePlotSize();
    }

}