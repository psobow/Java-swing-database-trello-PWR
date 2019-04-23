package ocado;

import java.util.*;

public class AlgorithmAPI {

    private List<Product> products = new ArrayList<>();
    private List<Bag> bags = new ArrayList<>();
    private Bag bag = new Bag();
    private double bagStrength = bag.getBagStrengthInGrams();

    public void fetchData(){
        // read data from .csv

        products.add(new Product(1, "Carrot",2000,"GR"));
        products.add(new Product(2, "Chicken",2000,"GR"));
        products.add(new Product(3, "Pepsi 2.5L",2,"KG"));
    }


    public void packProductsIntoBags(List<Long> productsID){
        if (products == null || products.size() == 0) throw new RuntimeException("Unable to pack products. Fetch data first!");

        bags.add(new Bag());

        Optional.ofNullable(productsID)
                .orElseThrow(IllegalArgumentException::new)
                .stream()
                .forEach(ID -> {
                    Product currentProduct = products.stream()
                            .filter(product -> product.getID() == ID)
                            .findAny()
                            .orElseThrow(() -> new RuntimeException("Product with ID = " + ID + " not found inside product list."));

                    for(int i = 0; i < bags.size(); i++){
                        if (bags.get(i).getBagStrengthInGrams() >=
                                bags.get(i).getWeightOfProductsInside() + currentProduct.getWeightInGrams()){

                            bags.get(i).addNewProduct(currentProduct);
                            break;
                        } else {
                            bags.add(new Bag());
                        }
                    }
                });
    }

    public void printResults(){
        for(int i = 0; i < bags.size(); i++){
            System.out.println("Bag number " + i + " contain: \n" + bags.get(i).toString());
        }
    }




    private double getProductsWeightInGrams(final List<Long> productsID){
        double resultWeight = 0;

        for(Long id : productsID){
            for(Product product : products){
                if( id == product.getID()){
                    resultWeight += product.getWeightInGrams();
                }
            }
        }
        return resultWeight;
    }

    private void prepareBags(final int quantityOfBags){
        for(int i = 0; i < quantityOfBags; i++){
            bags.add(new Bag());
        }
    }
}
