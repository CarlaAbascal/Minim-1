package edu.upc.dsa.models;

public class Piloto {
    private String id;
    private String nombre;
    private String apellido;
    private double horasVuelo;

    //ArrayList<Piloto> Match = new ArrayList<Piloto>();
    //HashMap<String, String> userCoins = new HashMap<>();

    //-------CONSTRUCTORES---------------
    public  Piloto(){};
    public Piloto(String id, String nombre, String apellido){
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
    }



    //-------GETTERS SETTERS--------------
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getHorasVuelo() {
        return horasVuelo;
    }

    public void setHorasVuelo(double horasVuelo) {
        this.horasVuelo = horasVuelo;
    }
}
