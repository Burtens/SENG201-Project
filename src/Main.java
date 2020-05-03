import java.lang.invoke.SwitchPoint;
import java.util.Arrays;
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

        /*Main Loop*/
        while (Status.getDay() <= farm.getDays()){
            atFarm(farm, scan);


        }


        scan.close();
    }

    private static void atFarm(Farm farm, Scanner scan){
        boolean GOTONEXTDAY = false;
        String selection = "";
        while (!GOTONEXTDAY)
        {
            System.out.println("Today is: Day " + Status.getDay() + ".\nWhat would you like to do today?");
            System.out.println("1: View your Farm's Status");
            System.out.println("2: Preform an Action");
            System.out.println("3: Travel to Store");
            System.out.println("4: Sleep");

            selection = scan.nextLine().trim();
            System.out.println("\n\n");
            switch (selection)
            {
                case "1" :
                    break;
                case "2" :
                    actions(farm, scan);
                    break;
                case "3" :
                    atShop(farm, scan);
                    break;
                case "4" :
                    Status.updateDay();
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
        else{
            if (actions == 1)
                System.out.println("You have 1 action remaining.");
            else
                System.out.println("You have " + actions + " actions remaining.");
            /*Loops while user chooses to preform an action*/
            while (INACTION) {
                System.out.println("What action would you like to preform?");
                System.out.println("1: Tend to Crops");
                System.out.println("2: Feed Animals");
                System.out.println("3: Play with Animals");
                System.out.println("4: Harvest Crops");
                System.out.println("5: Tend to Land");
                System.out.println("E: Exit");

                input = scan.nextLine().trim().toLowerCase();
                INACTION = false;
                switch (input) {
                    case "1":
                        System.out.println("Not implemented yet");
                        Status.updateActions(-1);
                        break;
                    case "2":
                        // TODO: Flynn is implementing this
                        Status.updateActions(-1);

                        break;
                    case "3":
                        // TODO: Flynn is implementing this
                        Status.updateActions(-1);
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
                        // TODO: Bag functionality
                        farm.updateFarmSize(null);
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

    private void endGame() {
        System.out.println(Farm.getName());
        System.out.println(Status.getMoney());
        System.out.println(Status.getDays());
        double score = 0;
        for (int pen = 0; pen < Farm.pens; pen++) {
            if (Farm.pens[pen] != null) {
                score += Farm.pens[pen].getValue
            }
        }
        score = (score * 10) / Farm.getDays();
        score += Status.getMoney();
        score = round(score);
        System.out.println(score);
    }

    private static void atShop(Farm farm, Scanner scan){
        System.out.println("Not implemented yet");
    }





    public static void main(String[] args)
    {
        startGame();
    }

}
