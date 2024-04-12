package edu.upc.dsa;

public interface GameManager {
    String createPlay(String id, int N_Team, int P_Players);
    void addUser(String idUser, String name, String surname, double dsaCoins);
    void addProduct(String idProduct, String description, double price);
    void buyProduct(String idProduct, String idUser);
    String startMatch(String idPlay, String idUser);
    String consultStatus(String idPlay);
    int consultLife(String idUser);
    String finishPlay(String idPlay);
    int numUsers();
    int numProducts();

    public int size();
}
