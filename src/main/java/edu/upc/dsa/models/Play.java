package edu.upc.dsa.models;

public class Play {
    String id;
    int N_Team;
    int P_Players;
    String status = "NO_INICIADO";

    //-------------CONSTRUCTORES----------------
    public Play(){}
    public Play(String id, int N_Team, int P_Players) {
        this.id = id;
        this.N_Team = N_Team;
        this.P_Players = P_Players;
    }

    //-----------GETTERS SETTERS-----------------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getN_Team() {
        return N_Team;
    }

    public void setN_Team(int n_Team) {
        N_Team = n_Team;
    }

    public int getP_Players() {
        return P_Players;
    }

    public void setP_Players(int p_Players) {
        P_Players = p_Players;
    }
}

