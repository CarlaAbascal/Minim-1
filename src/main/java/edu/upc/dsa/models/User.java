package edu.upc.dsa.models;

public class User {
    private String id;
    private String name;
    private String surname;
    //int Life;
    double dsaCoins;

    /*public static Map<String, User> MapUser = new HashMap<>();
    private List<Product> Inventory = new ArrayList<>();
    public List<Product> getInventory() {
        return this.Inventory;
    }
*/
    //-----------CONTRUCTORES--------------
    public User(){}
    public User(String id, String name, String surname, double dsaCoins){
        this.id = id;
        this.name=name;
        this.surname=surname;
        //this.Life = 100;
        this.dsaCoins = 25;
        //MapUser.put(this.id, this);
    }

    //--------GETTERS SETTERS----------------
    //--ID

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    //--Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        name = name;
    }
    //--Surname
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        surname = surname;
    }
    //--Life
    /*public int getLife() {
        return Life;
    }
    public void setLife(int life) {
        Life = life;
    }
    */

    //--dsaCoins
    public double getDsaCoins() {
        return dsaCoins;
    }
    public void setDsaCoins(double dsaCoins) {
        this.dsaCoins = dsaCoins;
    }
}
