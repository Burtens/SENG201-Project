import javafx.css.Size;

import java.lang.invoke.SwitchPoint;
import java.util.Arrays;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Scanner;
import static java.lang.Math.round;

public class Main {
    /**This class houses the Game environment for the game*/

    private static String farmerName;

    private static void setFarmerName(Scanner scan)
    {
        Utilities u = new Utilities();


        boolean VALID = false;
        /*Allows player to name farmer*/
        while (!VALID) {
            System.out.println("Please enter farmer name:\n(Please make name 3-15 characters long.)");
            String currName = scan.nextLine();
            if (currName.trim().length() < 3)
                System.out.println("Name too short.\nPlease make sure name is longer than 3 characters.");
            else if (currName.trim().length() > 15)
                System.out.println("Name to long.\nPlease make sure name is no longer than 15 characters.");
            else if (!u.checkString(currName.trim()))
                System.out.println("One or more invalid characters.\nPlease make sure only spaces and letters are used");
            else{
                farmerName = currName.trim();
                VALID = true;
            }
            System.out.print("\n\n");
        }

    }

    private static void startGame()
    {
        /*Setup*/
        System.out.println("Welcome to <<NAME>>.\n");
        Scanner scan = new Scanner(System.in);
        setFarmerName(scan);
        System.out.println("Welcome " + farmerName + "!");
        Farm farm = new Farm(false, null, scan);
        Seeds seed = new Seeds("Corn", 3);
        Bag.seeds.add(seed);
        /*Main Loop*/
        while (Status.getDay() <= farm.getDays()){
            atFarm(farm, scan);
            System.out.println(Bag.seeds);



        }
        scan.close();
        endGame(farm);
    }

    private static void atFarm(Farm farm, Scanner scan){
        boolean GOTONEXTDAY = false;
        String selection = "";
        while (!GOTONEXTDAY)
        {
            System.out.println("Today is: Day " + Status.getDay() + ".\nWhat would you like to do today?");
            System.out.println("1: View your Farm's Status and bag");
            System.out.println("2: Preform an Action");
            System.out.println("3: Travel to Store");
            System.out.println("4: Sleep");

            selection = scan.nextLine().trim();
            System.out.println("\n\n");
            switch (selection)
            {
                case "1" :

                    /*Prints current status of Farm*/
                    Status.viewStatus();
                    System.out.println("\nThe plants on your farm are:");
                    System.out.println("---------------------");
                    System.out.println("Plot : Plant (Growth)");
                    for (int i = 0; i < farm.plots.length; i++){
                        if (farm.plots[i] != null)
                            System.out.println(i + " : " + farm.plots[i].toString() + " (" + farm.plots[i].getGrowth() +"%)");
                    }
                    System.out.println("\nThe animals on your farm are:");
                    System.out.println("------------");
                    System.out.println("Pen : Animal");
                    for (int i = 0; i < farm.pens.length; i++){
                        if (farm.pens[i] != null)
                            // TODO : May want to show happiness and health
                            System.out.println(i + " : " + farm.pens[i].toString());
                    }
                    System.out.println("\n\n");
                    Bag.viewBag();

                    break;
                case "2" :
                    /*Sends user to actions method to allow user to preform an action*/
                    actions(farm, scan);
                    break;
                case "3" :

                    /*Sends user to shop method to allow them to view and buy items*/
                    System.out.println("Welcome to the shop, please choose an item number from the list.");
                    Shop.chooseItem(scan);
                    break;
                case "4" :
                    /*Updates day*/
                    Status.updateDay(farm);
                    GOTONEXTDAY = true;
                    break;
                default :
                    System.out.println("Please Select a valid option.");
                    System.out.println("\n\n");
                    break;
            }

        }

    }

    private static void actions(Farm farm, Scanner scan){
        /*Allows user to select an action to do if they are able*/
        boolean INACTION = true;
        String input;
        int actions = Status.getActions();
        if (actions == 0)
            System.out.println("Sorry you are unable to preform any more actions today.");
            // TODO: Add ability to still plant crops here
        else{
            if (actions == 1)
                System.out.println("You have 1 action remaining.");
            else
                System.out.println("You have " + actions + " actions remaining.");
            /*Loops while user chooses to preform an action*/
            while (INACTION) {
                System.out.println("What action would you like to preform?");
                System.out.println("P: Plant Crop (This doesn't cost an action)");
                System.out.println("1: Tend to Crops");
                System.out.println("2: Feed Animals");
                System.out.println("3: Play with Animals");
                System.out.println("4: Harvest Crops");
                System.out.println("5: Tend to Land");
                System.out.println("E: Exit");

                input = scan.nextLine().trim().toLowerCase();
                INACTION = false;
                switch (input) {
                    case "p":
                        /*Plants a crop is user has seed*/
                        plantCrop(scan, farm);
                        break;
                    case "1":
                        System.out.println("Not implemented yet");
                        Status.updateActions(-1);
                        break;
                    case "2":
                        if (Bag.getFoodAmount() > 0) {
                            Animals.feed();
                            Bag.updateItems("1", -1);
                            Status.updateActions(-1);
                        } else {
                            System.out.print("Not enough food.");
                        }
                        break;
                    case "3":
                        if (Bag.getToyAmount() > 0) {
                            Animals.feed();
                            Bag.updateItems("2", -1);
                            Status.updateActions(-1);
                        } else {
                            System.out.print("Not enough Toys.");
                        }
                        break;
                    case "4":
                        boolean ISCROP = false;
                        for (Crop crop : farm.plots)
                            if (crop != null)
                                ISCROP = true;

                        if (ISCROP){
                            farm.harvestCrop(scan);
                            Status.updateActions(-1);
                        }
                        else
                            System.out.println("There are currently no crops on your farm");
                        break;

                    case "5":

                        farm.updatePlotSize();
                        Status.updateActions(-1);
                        break;
                    case "e":
                        break;
                    default:
                        INACTION = true;
                        System.out.println("Please Select a valid option.");
                        System.out.println("\n\n");
                        break;
                }


            }
            System.out.println("\n\n");
        }

    }

    private static void endGame(Farm farm) {
        System.out.println("Name: " + farm.getName());
        System.out.println("Total money: $" + String.format("%.2f",Status.getMoney()));
        System.out.println("Total days: " + farm.getDays());
        double score = 0;
        for (int pen = 0; pen < farm.pens.length; pen++) {
            if (farm.pens[pen] != null) {
                score += farm.pens[pen].getValue();
            }
        }
        score = (score * 10) / farm.getDays();
   
        score += Status.getMoney();
        score = round(score);
        System.out.println("Final score: " + score);
    }

    private static void plantCrop(Scanner scan, Farm farm)
    {
        if (Bag.seeds.isEmpty())
            System.out.println("You do not have any seeds please buy some at the store.");
        else{
            String input = "e";

            boolean VALID = false;
            /*Asks for user input until user exits or uses correct input*/
            while (!VALID) {
                System.out.println("Please select seed you want to plant:");
                /*Prints all available seeds*/
                for (int i = 0; i < Bag.seeds.size(); i++) {
                        System.out.println(i + ": " + Bag.seeds.get(i).toString());
                }
                System.out.println("E: Exit");
                /*Gets input and checks if its valid*/
                try {
                    int num;
                    String seed;

                    input = scan.nextLine().trim().toLowerCase();
                    num = Integer.parseInt(input);
                    seed = Bag.seeds.get(num).toString();
                    farm.plantCrop(seed, farm, num);
                    VALID = true;
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid selection, please select a valid seed.");
                    System.out.println("\n\n");
                }
                catch (NumberFormatException e) {
                    if (input.equals("e"))
                        return;
                    else {
                        System.out.println("Invalid input, please input only numbers.");
                        System.out.println("\n\n");
                    }

                }
            }
        }
        System.out.println("\n\n");
 
    }

    public static void main(String[] args)
    {
        startGame();
    }

}
