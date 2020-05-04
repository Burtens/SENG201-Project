import Items.Items;

import java.util.Scanner;

public class Farm 
{

    private static String name;
    private FarmType farmType;
    private static int days;
    public static Crop[] plots = new Crop[4];
    public static Animals[] pens = new Animals[4];


    Farm(boolean testing, FarmType farmType, Scanner scan)
    {
        generateFarm(testing, farmType, scan);
    }

    private void generateFarm(boolean Testing, FarmType testFarmType, Scanner scan) {
        if (Testing)
            this.farmType = testFarmType;
        else {

            Boolean VALID = false;
            Utilities u = new Utilities();

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
                System.out.print("\n\n");

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
                System.out.print("\n\n");
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
                System.out.print("\n\n");

            }

            System.out.println("Your game will last: " + this.days + " days");
            System.out.println("Your chosen farm-type is: " + this.farmType.toString().toLowerCase());
            System.out.println("and the name of your farm is: " + this.name);
            System.out.println("\n\n");
        }


    }

    public void updatePlotSize()
    {
        /*Updates size of plots array (Increases amount of plots on farm)*/
        int plotsSize = this.plots.length;
        Crop[] newplots;
        if (Bag.hasHoe() == true){
            newplots = new Crop[plotsSize + 3];
            System.out.println("The use of a hoe made it easier to dig ground, an additional plot was created.");
        }
        else {
            newplots = new Crop[plotsSize + 2];
        }
        for (int i = 0; i < plotsSize; i++)
            newplots[i] = this.plots[i];
        this.plots = newplots;
    }
    
    public void updatePenSize() {
        int penSize = this.pens.length;
        Animals[] newPens;
        newPens = new Animals[penSize + 1];
        for (int i = 0; i < penSize; i++)
            newPens[i] = this.pens[i];
        this.pens = newPens;
    }
    
    public static void newAnimal(Animals animal) {
        boolean inPen = false;
        int numPens = pens.length;
        for (int i = 0; i < numPens; i++) {
            if (pens[i] == null) {
                pens[i] = animal;
                inPen = true;
                break;
            }
        }
        if (inPen) {
            System.out.println("Animal purchased successfully");
        } else
            System.out.println("Sorry no pens available.");
    }

    public void plantCrop(String seed, Farm farm, int seedNum) {
        /*Allows user to plant crops on farm*/
        boolean planted = false;
        int numplots = this.plots.length;
        int plotToPlant = 0;

        for (int i = 0; i < numplots; i++) {
            if (this.plots[i] == null) {
                plotToPlant = i;
                planted = true;
                break;
            }
        }

        if (planted) {
            /*Creates plant based on seed*/
            switch (seed){
                case "Corn":
                    this.plots[plotToPlant] = new Corn(farm);
                    break;
                case "Carrot":
                    this.plots[plotToPlant] = new Carrots(farm);
                    break;
                case "Lettuce":
                    this.plots[plotToPlant] = new Lettuce(farm);
                    break;
                case "Potatoes":
                    this.plots[plotToPlant] = new Potatoes(farm);
                    break;
                case "Strawberries":
                    this.plots[plotToPlant] = new Strawberries(farm);
                    break;
                case "Tomatoes":
                    this.plots[plotToPlant] = new Tomatoes(farm);
                    break;
            }

            System.out.println("Crop successfully planted.");
            Bag.seeds.get(seedNum).updateAmount(-1);
            if (Bag.seeds.get(seedNum).getAmount() == 0)
                Bag.seeds.remove(seedNum);
        } else
            System.out.println("Sorry no plots available to plant crop.");
    }

    public void harvestCrop(Scanner scan)
    {
        /*Allows User To Harvest Crop*/
        boolean VALID = false;
        int numplots = this.plots.length;
        Crop crop = null;
        int num = 0;
        String input = null;

        /*Asks for user input until user exits or uses correct input*/
        while (!VALID) {
            System.out.println("Select plot to harvest:");
            /*Prints all available crops*/
            for (int i = 0; i < numplots; i++) {
                if (this.plots[i] != null)
                    System.out.println(i + ": " + this.plots[i].toString());
            }
            System.out.println("E: Exit");
            /*Gets input and checks if its valid*/
            try {
                input = scan.nextLine().trim().toLowerCase();
                num = Integer.parseInt(input);
                crop = this.plots[num];
                if (crop == null)
                    throw new ArrayIndexOutOfBoundsException();
                else
                    VALID = true;
            }
            catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("Invalid plot, please select a valid plot.");
                    System.out.println("\n\n");
            }
            catch (NumberFormatException e) {
                if (input.equals("e"))
                    return;
                else{
                    System.out.println("Invalid input, please input only numbers.");
                    System.out.println("\n\n");
                }

            }
        }
        /*If the selected crop is valid and harvestable total money farm has will update and crop will be harvested*/
        if (crop.getGrowth() >= 100){
            Status.updateMoney(crop.getValue());
            this.plots[num] = null;
        }
        else
            System.out.println("Sorry this crop is not ready to be harvested!!!");
    }

    public void tendCrop(Items item , Scanner scan)
    {
        // TODO : Add functionality
    }

    public FarmType getFarmType(){ return farmType; }

    public static int getDays() { return days; }

    public static String getName() { return name; }

    public static String getFarmName() {return name;}
}
