package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Match {
    double dsaCoins=0;
    int Life=100;
    String status;
    String idPlay;
    String idUser;
    ArrayList<Match> Match = new ArrayList<Match>();
    HashMap<String, String> userCoins = new HashMap<>();

    //-------CONSTRUCTORES---------------
    public Match(){}
    public Match (String idPlay, String idUser){
        this.idPlay = idPlay;
        this.idUser = idUser;
    }

    //-------GETTERS SETTERS--------------
    public double getDsaCoins() {
        return dsaCoins;
    }

    public void setDsaCoins(double dsaCoins) {
        this.dsaCoins = dsaCoins;
    }

    public int getLife() {
        return Life;
    }

    public void setLife(int life) {
        Life = life;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdPlay() {
        return idPlay;
    }

    public void setIdPlay(String idPlay) {
        this.idPlay = idPlay;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    /*public ArrayList<Play> getPartidas() {
        return ;
    }

    public HashMap<String, String> getUsuarioCoins() {
        return usuarioCoins;
    }
    */
}
