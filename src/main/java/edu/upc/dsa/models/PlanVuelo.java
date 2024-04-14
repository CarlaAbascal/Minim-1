package edu.upc.dsa.models;

import java.util.Date;

public class PlanVuelo {
    private String idDron;
    private Date fecha;
    private double duracion;
    private  double posicionIni;
    private double posicionFin;
    private String idPiloto;

    //-----------CONSTRUCTORES--------------------------
    public PlanVuelo(){}
    public PlanVuelo(String idDron, Date fecha, double duracion, double posicionIni, double posicionFin, String idPiloto){
        this.idDron=idDron;
        this.fecha=fecha;
        this.duracion=duracion;
        this.posicionIni=posicionIni;
        this.posicionFin=posicionFin;
        this.idPiloto=idPiloto;
    }

    //-------------GETTERS SETTERS------------------------

    public String getIdDron() {
        return idDron;
    }

    public void setIdDron(String idDron) {
        this.idDron = idDron;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public double getPosicionIni() {
        return posicionIni;
    }

    public void setPosicionIni(double posicionIni) {
        this.posicionIni = posicionIni;
    }

    public double getPosicionFin() {
        return posicionFin;
    }

    public void setPosicionFin(double posicionFin) {
        this.posicionFin = posicionFin;
    }

    public String getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(String idPiloto) {
        this.idPiloto = idPiloto;
    }
}
