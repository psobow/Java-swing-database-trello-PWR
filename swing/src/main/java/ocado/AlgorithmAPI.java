package ocado;

import java.util.*;

public class AlgorithmAPI {

    private List<Product> products = new ArrayList<>();
    private List<Bag> bags = new ArrayList<>();


    public void fetchData(){
        // read data from .csv

        products.add(new Product(1, "Carrot",20,"GR"));
        products.add(new Product(2, "Chicken",500,"GR"));
        products.add(new Product(3, "Pepsi 2.5L",2.5,"KG"));
    }


    public void packProductsIntoBags(List<Long> productsID){
        if (products == null || products.size() == 0) throw new RuntimeException("Unable to pack products. Fetch data first!");

        int expectedBagsQuantity = (int) Math.ceil(getProductsWeightInGrams(productsID) / 3000);

        prepareBags(expectedBagsQuantity);

        Optional.ofNullable(productsID)
                .orElseThrow(IllegalArgumentException::new)
                .stream()
                .forEach(ID -> {
                    Product currentProduct = products.stream()
                            .filter(product -> product.getID() == ID)
                            .findAny()
                            .orElseThrow(() -> new RuntimeException("Product with ID = " + ID + " not found inside product list."));

                    for(Bag currentBag : bags){
                        if (currentBag.getBagStrengthInGrams() >=
                                currentBag.getWeightOfProductsInside() + currentProduct.getWeightInGrams()){

                            currentBag.addNewProduct(currentProduct);
                            break;
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
