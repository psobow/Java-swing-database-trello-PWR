package ocado;

import java.util.ArrayList;
import java.util.List;


public class Bag {
    private static final double DEFAULT_BAG_STRENGTH_IN_GRAMS = 3000.0;

    private double bagStrengthInGrams;
    private List<Product> productsInside = new ArrayList<>();

    public Bag(){
        setBagStrengthInGrams(DEFAULT_BAG_STRENGTH_IN_GRAMS);
    }

    public Bag(final double bagStrengthInGrams) {
        setBagStrengthInGrams(bagStrengthInGrams);
    }

    public double getBagStrengthInGrams() {
        return bagStrengthInGrams;
    }

    public void setBagStrengthInGrams(final double newBagStrength) {
        if (newBagStrength <= 0) throw new IllegalArgumentException("Unable to init bag with nonpositive strength.");
        this.bagStrengthInGrams = newBagStrength;
    }

    public void addNewProduct(final Product newProduct){
        if (newProduct.getWeightInGrams() > this.bagStrengthInGrams) throw new IllegalArgumentException("Product weigh exceed bag strength.");
        productsInside.add(newProduct);
    }

    public double getWeightOfProductsInside(){
        return productsInside.stream()
                .map(product -> product.getWeightInGrams())
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    @Override
    public String toString(){
        String result = "";
        for(Product product : productsInside){
            result+= "      " + product.toString() + "\n";
        }
        return result;
    }
}
