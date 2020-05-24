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
        Status.updateActions(2);
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


    @Test
    void animalUpdateHealthTest() {
        Cow cow = new Cow();
        assertEquals(100, cow.getHealth());
        cow.updateHealth(20);
        assertEquals(100, cow.getHealth());
        cow.updateHealth(-110);
        assertEquals(0, cow.getHealth());
        Chicken chicken = new Chicken();
        assertEquals(50, chicken.getHealth());
        chicken.updateHealth(10);
        assertEquals(50, chicken.getHealth());
        chicken.updateHealth(-60);
        assertEquals(0, chicken.getHealth());
    }


    @Test
    void animalUpdateHappinessTest() {
        Cow cow = new Cow();
        assertEquals(100, cow.getHappiness());
        cow.updateHappiness(10);
        assertEquals(100, cow.getHappiness());
        cow.updateHappiness(-110);
        assertEquals(0, cow.getHappiness());
    }


    @Test
    void animalGetValueTest() {
        Cow cow = new Cow();
        assertEquals(100, cow.getValue());
        cow.updateHealth(-50);
        assertEquals(75, cow.getValue());
        cow = new Cow();
        cow.updateHappiness(-50);
        assertEquals(75, cow.getValue());
        Chicken chicken = new Chicken();
        assertEquals(50, chicken.getValue());
        chicken.updateHealth(-25);
        assertEquals(38, chicken.getValue());
        chicken = new Chicken();
        chicken.updateHappiness(-50);
        assertEquals(38, chicken.getValue());
    }


    @Test
    void animalFeedTest() {
        Cow cow = new Cow();
        cow.feed();
        assertEquals(100, cow.getHealth());
        assertEquals(100, cow.getHappiness());
        assertEquals(1, Status.getActions());
        cow.updateHealth(-100);
        cow.updateHappiness(-100);
        cow.feed();
        assertEquals(40, cow.getHealth());
        assertEquals(20, cow.getHappiness());
        assertEquals(0, Status.getActions());
        cow.feed();
        assertEquals(80, cow.getHealth());
        assertEquals(40, cow.getHappiness());
        assertEquals(0, Status.getActions());
    }


    @Test
    void animalPlayTest() {
        Cow cow = new Cow();
        cow.play();
        assertEquals(100, cow.getHappiness());
        assertEquals(1, Status.getActions());
        cow.updateHappiness(-100);
        cow.play();
        assertEquals(50, cow.getHappiness());
        assertEquals(0, Status.getActions());
        cow.play();
        assertEquals(100, cow.getHappiness());
        assertEquals(0, Status.getActions());
    }
}
