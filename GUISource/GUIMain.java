import javax.swing.*;
import java.awt.*;


/***
 * This will be the main class to run the GUI Based game
 * This class will hold all the functionality to move from screen to screen and will hold
 * key information, such as UserName.
 *
 * We will also initialise all forms from here as the intellij swing designer is a little different from
 * window builder
 *
 * Should setup all screen transitions from here
 *
 * Variables:
 * farm: GUIFarm
 * setupScreen: JFrame
 *
 * Methods:
 * launchSetupScreen: Initialises the setupScreen
 * closeSetupScreen: Closes the setupScreen and sets starting values to the farm
 *
 * */


public class GUIMain {

    GUIFarm farm = new GUIFarm();
    JFrame setupScreen = new JFrame("Create Farm");
    JFrame farmScreen = new JFrame("Farm");

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
        System.out.println(farm.getDays());
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

    public void endGame()
    {
        farmScreen.dispose();
        // TODO: Show End Screen
    }


    public static void main(String[] args)
    {
        GUIMain main = new GUIMain();
        main.launchSetupScreen();
    }

}


