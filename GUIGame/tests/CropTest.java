import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CropTest {

    static Farm farm;

    @BeforeEach
    void setupFarm(){
        farm = new Farm();
        farm.setFarmType(FarmType.BASIC);


    }

    @Test
    void testingFarmTypeEffect()
    {
        /*Basic Farm has no effect on growth*/
        Crop potato1 = new Potatoes(farm);
        assertEquals(25, potato1.getGrowthRate());

        /*River Farm increases the growth of crop by 25%*/
        farm.setFarmType(FarmType.RIVER);
        Crop potato2 = new Potatoes(farm);
        assertEquals(25*FarmType.RIVER.getCropPercent(), potato2.getGrowthRate());

        /*River Farm decreases the growth of crop by 50%*/
        farm.setFarmType(FarmType.BARRON);
        Crop potato3 = new Potatoes(farm);
        assertEquals(25*FarmType.BARRON.getCropPercent(), potato3.getGrowthRate());
    }

    @Test
    void testingUpdateGrowth(){
        Crop potato1 = new Potatoes(farm);
        Crop grape1 = new Grapes(farm);

        assertEquals(0, potato1.getGrowth());
        assertEquals(0, grape1.getGrowth());

        potato1.updateGrowth();
        grape1.updateGrowth();
        assertEquals(25, potato1.getGrowth());
        assertEquals(10, grape1.getGrowth());

        /*Checks to see if growth-rate maxes at 100%*/
        for (int i = 0; i < 10; i++){
            potato1.updateGrowth();
            grape1.updateGrowth();
        }

        assertEquals(100, potato1.getGrowth());
        assertEquals(100, grape1.getGrowth());

    }

    @Test
    void testTend(){
        Crop turnip1 = new Turnips(farm);
        /*Tend with watering can*/
        turnip1.tend("Watering Can");
        assertEquals(25, turnip1.getGrowth());

        /*Tend with fertilizer*/
        turnip1.tend("growth");
        assertEquals(50, turnip1.getGrowthRate());
        
        turnip1.tend("value");
        assertEquals(40*1.25, turnip1.getValue());


    }





}