import com.sun.source.tree.CatchTree;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FarmTest {
    private static Farm farm;

    @BeforeAll
    static void setup(){
        farm = new Farm();
        farm.setFarmType(FarmType.BASIC);
        /*checks if farmType is correct when set*/
        assertEquals(FarmType.BASIC, farm.getFarmType());
        Bag.updateSeeds("Corn", 1);
        /*Checks to see if bag actually contains seed*/
        assertEquals(1, Bag.getSeeds().size());
        Bag.updateSeeds("Grapes",1);
        Bag.updateSeeds("Potatoes",1);
        Bag.updateSeeds("Turnips",1);
        Bag.updateSeeds("Strawberries",1);
        Bag.updateSeeds("Tomatoes",1);
    }

    @Test
    void testPlantCrop(){

        farm.plantCrop("Corn", 0, 1);
        int totalCrops = 0;
        for (Crop crop : farm.getPlots()){
            if (crop != null){
                totalCrops ++;
            }
        }
        assertEquals(1, totalCrops);
        /*Checks if seed is removed*/
        assertEquals(5, Bag.getSeeds().size());

        farm.plantCrop("Grapes", 0, 0);
        farm.plantCrop("Potatoes", 0, 1);
        String crops = "";
        for (Crop crop : farm.getPlots()){
            if (crop != null){
                crops = crops + crop.toString() + ' ';
            }
        }

        assertEquals("Grapes Potatoes", crops.trim());

        /*Checks if seeds are removed*/
        assertEquals(3, Bag.getSeeds().size());

        /*Checks if the right seeds are removed while planting*/
        String seeds = "";
        for(Object seed : Bag.getSeeds().toArray()){
            seeds = seeds + seed.toString() + ' ';
        }

        assertEquals("Turnips Strawberries Tomatoes", seeds.trim());

        /*Finally Checks if all the rest of the seeds can be planted*/
        farm.plantCrop("Turnips", 0, 1);
        farm.plantCrop("Strawberries", 0, 2);
        farm.plantCrop("Tomatoes", 0, 3);

        crops = "";
        for (Crop crop : farm.getPlots()){
            if (crop != null){
                crops = crops + crop.toString() + ' ';
            }
        }

        assertEquals("Grapes Turnips Strawberries Tomatoes", crops.trim());

    }

    @Test
    void testTendingPlots(){
        /*Checks if the number of plots is initially equal to 4*/
        assertEquals(4, farm.getPlots().length);

        /*Checks if the plot size is increased by 2 if the plots are tended to*/
        farm.updatePlotSize();
        assertEquals(6, farm.getPlots().length);

        /*Checks if the plot size increases by 3 if user has bought hoe*/
        Bag.setHasHoe(true);
        farm.updatePlotSize();
        assertEquals(9, farm.getPlots().length);

        /*Checks if the plot size can increase over 12 this should not happen*/
        farm.updatePlotSize();
        farm.updatePlotSize();
        assertEquals(12, farm.getPlots().length);

        /*Checks if you can plant in newly created plots*/
        Bag.updateSeeds("Tomatoes", 3);
        farm.plantCrop("Tomatoes", 0, 5);
        farm.plantCrop("Tomatoes", 0, 8);
        farm.plantCrop("Tomatoes", 0, 11);

        /*This also tests if Crop.toString() works correctly*/
        assertEquals("Tomatoes", farm.getPlots()[5].toString());
        assertEquals("Tomatoes", farm.getPlots()[8].toString());
        assertEquals("Tomatoes", farm.getPlots()[11].toString());
    }

    






}