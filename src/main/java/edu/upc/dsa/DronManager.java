package edu.upc.dsa;
import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.models.PlanVuelo;

import javax.validation.OverridesAttribute;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public interface DronManager {

    public List<Dron> dronesPorHorasVuelo();
    public List<Piloto> pilotosPorHorasVuelo();
    public List<PlanVuelo>pilotoPlanVuelo(Piloto piloto);
    public List<PlanVuelo>dronPlanVuelo(Dron dron);


    void addReservaVuelo(String idDron, Date fecha, double duracion, double posicionIni,
                    double posicionFin,String idPiloto );

    void addDron(String id, String nombre, String fabricante, String modelo);
    void addPiloto(String id, String nombre, String apellido);

    public void almacenDron(Dron idDron);
    public void repararDron(Dron idDron);



    int numDrones();

    int numPrilotos();

    int size();

}
