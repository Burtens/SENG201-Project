/**
 * Holds values for the different farm types. These values effect the happiness of animals
 * and growth rate of crops
 */
public enum FarmType {
    BASIC (1,1),
    RIVER (1, 1.5),
    MEADOW (1.5, 1),
    BARRON (0.5, 0.5);

    private final double animalPercent;
    private final double cropPercent;


    FarmType(double animalPercent, double cropPercent)
    {
        this.animalPercent = animalPercent;
        this.cropPercent = cropPercent;
    }

    public double getAnimalPercent() {return animalPercent;}
    public double getCropPercent() {return cropPercent;}



}
