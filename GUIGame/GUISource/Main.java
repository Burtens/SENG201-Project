import javax.swing.*;


/***
 * This will be the main class to run the GUI Based game
 * This class will hold all the functionality to move from screen to screen and will hold
 * key information, such as UserName.
 *
 * We will also initialise all forms from here as the intellij swing designer is a little different from
 * windowbuilder
 *
 * Should setup all screen transitions from here
 *
 * Variables:
 * farm: Farm
 * setupScreen: JFrame
 * farmScreen: JFrame
 * bagScreen: JFrame
 * shopScreen: JFrame
 * cropScreen: JFrame
 *
 * Methods:
 * launchSetupScreen: Initialises the setupScreen
 * closeSetupScreen: Closes the setupScreen and sets starting values to the farm
 * launchFarmScreen: Initialises the farmScreen this will act as a main hub in our game
 * closeFarmScreen: Closes farm screen
 * launchCropScreen : Initialises the cropScreen, this will be used to allow the user to access the crops on his or her
 *                      farm.
 * closeCropScreen : Closes cropScreen, returns user to farm after disposing.
 *
 * */


public class Main {

    Farm farm = new Farm();
    JFrame setupScreen = new JFrame("Create Farm");
    JFrame farmScreen = new JFrame("Farm");
    JFrame bagScreen = new JFrame("Bag");
    JFrame shopScreen = new JFrame("Shop");
    JFrame cropScreen = new JFrame("Crops");
    JFrame cropDetailScreen = new JFrame("Details");
    JFrame penScreen = new JFrame("Pens");
    JFrame animalScreen = new JFrame("Animals");
    JFrame endScreen = new JFrame("End");

    /*Launches initial setup screen*/
    public void launchSetupScreen()
    {
        setupScreen.setContentPane(new SetupScreen(this).getMainPanel());
        setupScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupScreen.pack();
        setupScreen.setResizable(false);
        setupScreen.setSize(600, 500);
        setupScreen.setVisible(true);
    }

    /*Closes SetupScreen and loads information into farm will then open main farm screen*/
    public void closeSetupScreen(SetupScreen screen, FarmType selectedFarmType)
    {
        /*Sets farm based on info stored on SetupScreen*/
        farm.setFarmName(screen.getFarmName().trim());
        farm.setFarmerName(screen.getFarmerName().trim());
        farm.setDays(screen.getDays());
        farm.setFarmType(selectedFarmType);
        setupScreen.dispose();
        launchFarmScreen();
    }



    public void launchFarmScreen(){
        farmScreen.setContentPane(new FarmScreen(this, farm).getMainPanel());
        farmScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        farmScreen.pack();
        farmScreen.setResizable(false);
        farmScreen.setSize(600, 500);
        farmScreen.setVisible(true);


    }

    public void launchCropScreen(){
        cropScreen.setContentPane(new CropScreen(this, farm).getMainPanel());
        cropScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        cropScreen.pack();
        cropScreen.setResizable(false);
        cropScreen.setSize(600, 500);
        cropScreen.setVisible(true);
        farmScreen.dispose();

    }

    public void closeCropScreen(){
        cropScreen.dispose();
        launchFarmScreen();
    }

    public void launchPenScreen(){
        penScreen.setContentPane(new PenScreen(this).getMainPanel());
        penScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        penScreen.pack();
        penScreen.setResizable(false);
        penScreen.setSize(600, 500);
        penScreen.setVisible(true);
    }

    public void closePenScreen(){
        penScreen.dispose();
        launchFarmScreen();
    }

    public void launchAnimalScreen(int pen) {
        animalScreen.setContentPane(new AnimalScreen(this, pen).getMain());
        animalScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        animalScreen.pack();
        animalScreen.setResizable(false);
        animalScreen.setSize(600, 500);
        animalScreen.setVisible(true);
    }

    public void closeAnimalScreen() {
        animalScreen.dispose();
        launchPenScreen();
    }

    public void launchBag(){
        bagScreen.setContentPane(new BagScreen(this).getMainPanel());
        bagScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        bagScreen.pack();
        bagScreen.setResizable(false);
        bagScreen.setSize(600, 500);
        bagScreen.setVisible(true);
    }

    public void closeBag() {
        bagScreen.dispose();
    }

    public void launchShop(){
        /* Closes Farm on opening shop*/
        farmScreen.dispose();
        shopScreen.setContentPane(new ShopScreen(this).getMainPanel());
        shopScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        shopScreen.pack();
        shopScreen.setResizable(false);
        shopScreen.setSize(600, 500);
        shopScreen.setVisible(true);
    }

    public void closeShop()
    {
        shopScreen.dispose();
        launchFarmScreen();
    }


    public void launchCropDetailScreen(int plotNum) {
        cropScreen.dispose();
        cropDetailScreen.setContentPane(new CropDetailScreen(this, plotNum, farm).getMainPanel());
        cropDetailScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        cropDetailScreen.pack();
        cropDetailScreen.setResizable(false);
        cropDetailScreen.setSize(600, 500);
        cropDetailScreen.setVisible(true);
    }

    public void closeCropDetailScreen(){
        cropDetailScreen.dispose();
        launchCropScreen();
    }

    public void endGame() {
        farmScreen.dispose();
        endScreen.setContentPane(new EndScreen(this).getMainPanel());
        endScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        endScreen.pack();
        endScreen.setResizable(false);
        endScreen.setSize(600, 500);
        endScreen.setVisible(true);
    }

    public void closeEndScreen() {
        endScreen.dispose();
    }

    public static void main(String[] args)
    {
        Main main = new Main();
        main.launchSetupScreen();
    }



}


