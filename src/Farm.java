import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Farm 
{

    private String name;
    private FarmType farmType;
    private int days;
    public Crop[] plots = new Crop[4];


    Farm(boolean testing, FarmType farmType)
    {
        Arrays.fill(plots, null);
        generateFarm(testing, farmType);
    }

    private void generateFarm(boolean Testing, FarmType testFarmType) {
        if (Testing)
            this.farmType = testFarmType;
        else {

            Boolean VALID = false;
            Utilities u = new Utilities();
            Scanner scan = new Scanner(System.in);

            while (!VALID) {
                System.out.println("Please enter the amount of days you want to play:\n(Between 5 to 10 days)");
                try {
                    int currDays = Integer.parseInt(scan.nextLine().trim());
                    if (currDays < 5 || currDays > 10)
                        System.out.println("Invalid number of days imputed.");
                    else {
                        this.days = currDays;
                        VALID = true;
                    }


                } catch (NumberFormatException e) {
                    System.out.println("Invalid input, please only enter numbers.");
                }
                u.waitTimer(1);

            }

            VALID = false;
            /*User selects farm type*/

            while (!VALID) {
                int i = 1;
                System.out.println("Please select farm type:");
                for (FarmType farm : FarmType.values()) {
                    System.out.println(i + ":" + farm);
                    i++;
                }

                String choice = scan.nextLine();
                VALID = true;
                switch (choice.trim()) {
                    case "1":
                        this.farmType = FarmType.BASIC;
                        break;
                    case "2":
                        this.farmType = FarmType.RIVER;
                        break;
                    case "3":
                        this.farmType = FarmType.MEADOW;
                        break;
                    case "4":
                        this.farmType = FarmType.BARRON;
                        break;
                    default:
                        VALID = false;
                        System.out.print("Invalid input, please enter valid number.\n");
                        break;
                }
                u.waitTimer(1);
            }

            VALID = false;
            /*Allows Farmer to Name Farm*/
            while (!VALID) {
                System.out.println("Please enter farm name:\n(Please make name 3-15 characters long.)");
                String currName = scan.nextLine();
                if (currName.length() < 3)
                    System.out.println("Name too short.\nPlease make sure name is longer than 3 characters.");
                else if (currName.length() > 15)
                    System.out.println("Name to long.\nPlease make sure name is no longer than 15 characters.");
                else {
                    this.name = currName.trim();
                    VALID = true;
                }
                u.waitTimer(1);

            }

            scan.close();


            System.out.println("Your game will last: " + this.days + " days");
            System.out.println("Your chosen farm-type is: " + this.farmType.toString().toLowerCase());
            System.out.println("and the name of your farm is: " + this.name);
        }


    }

    public void updateFarmSize()
    {
        /*Updates size of plots array (Increases amount of plots on farm)*/
        int currSize = this.plots.length;
        Crop[] newplots = new Crop[currSize + 2];
        for (int i = 0; i < currSize; i++)
            newplots[i] = this.plots[i];
        this.plots = newplots;
    }
    public FarmType getFarmType(){ return farmType; }

    public int getDays() { return days; }

    public String getName() { return name; }



    
}