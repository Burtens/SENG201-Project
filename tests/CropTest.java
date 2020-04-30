import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/*Since all crops are the same initially until we change base values im only testing one type of crop*/
class CropTest {



    @Test
    void testMakeCarrotBasic()
    {
        Farm newFarm = new Farm(true, FarmType.BASIC);
        Crop newCarrot = new Carrots(newFarm);
        double value = 10*1;
        assertEquals(value, newCarrot.growthRate);
        newCarrot.updateGrowth();
        assertEquals(10, newCarrot.getGrowth());
        newCarrot.harvest();
    }

    @Test
    void testMakeCarrotRiver()
    {
        Farm newFarm = new Farm(true, FarmType.RIVER);
        Crop newCarrot = new Carrots(newFarm);
        double value = 10*1.5;
        assertEquals(value, newCarrot.growthRate);
        newCarrot.updateGrowth();
        assertEquals(15, newCarrot.getGrowth());
    }

    @Test
    void testMakeCarrotBarron()
    {
        Farm newFarm = new Farm(true, FarmType.BARRON);
        Crop newCarrot = new Carrots(newFarm);
        double value = 10*0.5;
        assertEquals(value, newCarrot.growthRate);
        newCarrot.updateGrowth();
        assertEquals(5, newCarrot.getGrowth());
    }



}