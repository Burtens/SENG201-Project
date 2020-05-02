import java.lang.invoke.SwitchPoint;
import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.Scanner;

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
            System.out.println("Today is: Day " + Status.getDay() + ".\nWhat would you like to do today?");
            atFarm(farm, scan);


        }


        scan.close();
    }

    private static void atFarm(Farm farm, Scanner scan){
        boolean GOTONEXTDAY = false;
        String selection = "";
        while (!GOTONEXTDAY)
        {
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
        System.out.println("Not implemented yet");
    }

    private static void atShop(Farm farm, Scanner scan){
        System.out.println("Not implemented yet");
    }





    public static void main(String[] args)
    {
        startGame();
    }

}
