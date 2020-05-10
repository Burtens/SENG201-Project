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
 * */


public class GUIMain {

    GUIFarm farm = new GUIFarm();
    JFrame setupScreen = new JFrame("Create Farm");

    public void launchSetupScreen()
    {
        setupScreen.setContentPane(new SetupScreen(this).getMainPanel());
        setupScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupScreen.pack();
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
        // TODO: Send to FarmScreen
    }


    public static void main(String[] args)
    {
        GUIMain main = new GUIMain();
        main.launchSetupScreen();
    }

}


