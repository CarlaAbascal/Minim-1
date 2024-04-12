package edu.upc.dsa.models;

public class Product {
    private String id;
    private String description;
    double price;
    //public static Map<String, Product> Shop = new HashMap<>();

    //----------CONSTRUCTORES-------------
    public Product(){}
    public Product(String id, String description, double price){
        this.id = id;
        this.description=description;
        this.price=price;
        //Shop.put(this.id, this);
    }
    //--------GETTERS SETTERS--------------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
