import java.util.Scanner;

import static java.lang.Math.cbrt;
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
        /*Main Loop*/
        Shop.farm = farm;
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
                    Status.viewStatus(farm);
                    System.out.println("\nTotal Plots: " + farm.getPlots().length);
                    System.out.println("The plants on your farm are:");
                    System.out.println("---------------------");
                    System.out.println("Plot : Plant (Growth)");
                    for (int i = 0; i < farm.getPlots().length; i++){
                        if (farm.getPlots()[i] != null)
                            System.out.println(i + " : " + farm.getPlots()[i].toString() + " (" + farm.getPlots()[i].getGrowth() +"%)");
                    }
                    System.out.println("\nTotal Pens: " + farm.getPens().length);
                    System.out.println("The animals on your farm are:");
                    System.out.println("------------");
                    System.out.println("Pen : Animal");
                    for (int i = 0; i < farm.getPens().length; i++){
                        if (farm.getPens()[i] != null)
                            // TODO : May want to show happiness and health
                            System.out.println(i+1 + " : " + farm.getPens()[i].getClass().getSimpleName());
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
        if (actions == 0) {
            System.out.println("Sorry you are unable to preform any more actions today.");
            System.out.println("But you may plant crops");
            System.out.println("Would you like to? (Y or N)");
            input = scan.nextLine().trim().toLowerCase();
            if (input.equals("yes") || input.equals("y")){
                plantCrop(scan, farm);
            }
            else if (input.equals("no") || input.equals("n"))
                return;
            else
                System.out.println("Invalid input returning");
        }
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
                System.out.println("2: Animal menu");
                System.out.println("3: Harvest Crops");
                System.out.println("4: Tend to Land");
                System.out.println("E: Exit");

                input = scan.nextLine().trim().toLowerCase();
                INACTION = false;
                switch (input) {
                    case "p":
                        /*Plants a crop is user has seed*/
                        plantCrop(scan, farm);
                        break;
                    case "1":
                        tendCrop(scan, farm);
                        break;
                    case "2":
                        Animals.chooseAnimal(scan, farm);
                        break;
                    case "3":
                        boolean ISCROP = false;
                        for (Crop crop : farm.getPlots())
                            if (crop != null)
                                ISCROP = true;

                        if (ISCROP){
                            farm.harvestCrop(scan);
                        }
                        else
                            System.out.println("There are currently no crops on your farm");
                        break;

                    case "4":
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
        for (int pen = 0; pen < farm.getPens().length; pen++) {
            if (farm.getPens()[pen] != null) {
                score += farm.getPens()[pen].getValue();
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

    private static void tendCrop(Scanner scan, Farm farm){
        boolean VALID = false;
        boolean empty = true;
        String input;

        for (Crop crop : farm.getPlots())
            if (crop != null){
                empty = false;
                break;
            }
        if (empty)
            System.out.println("Sorry there are no plots to tend.");
        else {
            while (!VALID) {
                VALID = true;
                System.out.println("Please select item you would like to use:");
                if (Bag.hasWateringCan())
                    System.out.println("1: Watering Can");
                if (Bag.getGFertilizerAmount() > 0)
                    System.out.println("2: Growth Fertilizer");
                if (Bag.getVFertilizerAmount() > 0)
                    System.out.println("3: Value Fertilizer");
                System.out.println("E: Exit");
                input = scan.nextLine().trim().toLowerCase();
                switch (input) {
                    case "1":
                        farm.tendCrop("wateringCan", scan);
                        break;
                    case "2":
                        farm.tendCrop("growth", scan);
                        break;
                    case "3":
                        farm.tendCrop("value", scan);
                        break;
                    case "e":
                        return;
                    default:
                        VALID = false;
                        System.out.println("Invalid input, please try again.");
                        break;
                }

            }
        }

    }

    public static void main(String[] args)
    {
        startGame();
    }

}
