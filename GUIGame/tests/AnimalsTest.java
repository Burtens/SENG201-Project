import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AnimalsTest {

    Main main;
    Animals[] pens;

    @BeforeEach
    void start() {
        main = new Main();
        pens = main.farm.getPens();
        main.farm.newAnimal(new Chicken());
        main.farm.newAnimal(new Cow());
        main.farm.newAnimal(new Pig());
        main.farm.newAnimal(new Sheep());
    }


    @Test
    void penTest() {
        /* Checks that pens initializes to the right length */
        assertEquals(4, pens.length);
        /*  Checks that all pens contain the right type of animal */
        assertEquals(pens[0].getClass().getSimpleName(), "Chicken");
        assertEquals(pens[1].getClass().getSimpleName(), "Cow");
        assertEquals(pens[2].getClass().getSimpleName(), "Pig");
        assertEquals(pens[3].getClass().getSimpleName(), "Sheep");
        /* Checks that trying to add an animal over the limit dose not affect the list */
        main.farm.newAnimal(new Chicken());
        assertEquals(4, pens.length);
    }


    @Test
    void animalVariablesTest() {
        /* Checks that health happiness and value all initialize to the right value */
        assertEquals(50, pens[0].getHealth());
        assertEquals(100, pens[1].getHealth());
        assertEquals(80, pens[2].getHealth());
        assertEquals(70, pens[3].getHealth());
        for (int i = 0; i < pens.length; i++) {
            assertEquals(100, pens[i].getHappiness());
        }
        assertEquals(50, pens[0].getValue());
        assertEquals(100, pens[1].getValue());
        assertEquals(80, pens[2].getValue());
        assertEquals(70, pens[3].getValue());
    }
}
