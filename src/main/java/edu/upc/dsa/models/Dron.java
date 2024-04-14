package edu.upc.dsa.models;

public class Dron {
    private String id;
    private String nombre;
    private String fabricante;
    private String modelo;
    private double horasVuelo;
    private int reparar=0;


    //-----------CONTRUCTORES--------------
    public Dron(){}
    public Dron(String id, String nombre, String fabricante, String modelo){
        this.id = id;
        this.nombre=nombre;
        this.fabricante=fabricante;
        this.modelo=modelo;
        this.horasVuelo=0;
        this.reparar=reparar;

        //MapUser.put(this.id, this);
    }

    //--------GETTERS SETTERS----------------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getReparar() {
        return reparar;
    }

    public void setReparar(int reparar) {
        this.reparar = reparar;
    }

    public double getHorasVuelo() {
        return horasVuelo;
    }

    public void setHorasVuelo(double horasVuelo) {
        this.horasVuelo = horasVuelo;
    }
}
