import javax.swing.*;
import java.awt.*;


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
 * farm: GUIFarm
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


public class GUIMain {

    GUIFarm farm = new GUIFarm();
    JFrame setupScreen = new JFrame("Create Farm");
    JFrame farmScreen = new JFrame("Farm");
    JFrame bagScreen = new JFrame("Bag");
    JFrame shopScreen = new JFrame("Welcome to Shop");
    JFrame cropScreen = new JFrame("Crops");

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
    public void closeSetupScreen(SetupScreen screen)
    {
        /*Sets farm based on info stored on SetupScreen*/
        farm.setFarmName(screen.getFarmName().trim());
        farm.setFarmerName(screen.getFarmerName().trim());
        farm.setDays(screen.getDays());
        farm.setFarmType(screen.getSelectedFarmType());
        setupScreen.dispose();
        launchFarmScreen();
    }


    public void launchFarmScreen(){
        farmScreen.setContentPane(new FarmScreen(this).getMainPanel());
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

    }

    public void closeCropScreen(){
        cropScreen.dispose();
        launchFarmScreen();
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

    public void endGame()
    {
        farmScreen.dispose();
        // TODO: Show End Screen
    }

    public static void main(String[] args)
    {
        GUIMain main = new GUIMain();
        //main.launchSetupScreen();
        main.launchCropScreen();
    }


}


