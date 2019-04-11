package ocado;

public class Product {
    private long ID;
    private String name;
    private double weight;
    private String weightUnit;
    private double weightInGrams;

    public Product(long ID, String name, double weight, String weightUnit) {
        if (weight <= 0) throw new IllegalArgumentException("Unable to init product with nonpositive strength.");

        if ( ! weightUnit.equalsIgnoreCase("KG") &&
             ! weightUnit.equalsIgnoreCase("GR")) throw new IllegalArgumentException("Invalid weight unit.");

        this.ID = ID;
        this.name = name;
        this.weight = weight;
        this.weightUnit = weightUnit;

        weightInGrams = weightUnit.equalsIgnoreCase("KG") ? weight * 1000 : weight;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getWeightInGrams() {
        return weightInGrams;
    }

    @Override
    public String toString(){
        return "Product ID: " + this.ID + " Name: " + this.name;
    }
}
