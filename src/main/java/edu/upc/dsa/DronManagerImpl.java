package edu.upc.dsa;

import edu.upc.dsa.models.*;
import io.swagger.models.Response;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class DronManagerImpl implements DronManager {
    private static DronManager manager;
    //---------Singletone------------
    public static DronManager getManager() {
        if (manager == null) manager = new DronManagerImpl();
        return manager;
    }
    final static Logger logger = Logger.getLogger(DronManagerImpl.class);

    LinkedList<Dron> listDron;
    LinkedList<Piloto>listPiloto;
    LinkedList<Dron> listaAlmacen;
    LinkedList<PlanVuelo> listaPlanVuelos;
    List<PlanVuelo> listaFechas;

    //-----------CONSTRUCTORES-------------------
    public DronManagerImpl(){
        this.listDron=new LinkedList<>();
        this.listPiloto=new LinkedList<>();
        this.listaAlmacen=new LinkedList<>();
        this.listaPlanVuelos=new LinkedList<>();

    }

    @Override
    //------------FUNCIONES-----------------------
    //------------AddDron-------------------------
    public void addDron(String id, String nombre, String fabricante, String modelo) {
        Dron dron;
        logger.info("Comprobmos si ya existe un dron con id: " + id);

        if (listDron.contains(id)) {
            logger.error("Ya existe este dron");
        } else {
            logger.info("Creamos nuevo dron con id " + id);
            dron = new Dron(id, nombre, fabricante, modelo);
            //Lo añadimos a la lista como ultimo elemento
            listDron.addLast(dron);
        }
    }


    //---------------AddPiloto-------------------------
    public void addPiloto(String id, String nombre, String apellido) {
        Piloto piloto;
        logger.info("Comprobamos si ya existe el piloto con id: " + id);

        if (listPiloto.contains(id)) {
            logger.error("Ya existe este piloto");
        } else {
            logger.info("Añadimos nuevo piloto con id " + id);
            piloto= new Piloto(id,nombre,apellido);
            //Lo añadimos a la lista, ultimo elemento
            listPiloto.addLast(piloto);
        }
    }

    //Comprobar si el dron esta en almacen o no, en caso de q no este se añade
    public void almacenDron(Dron idDron) {
        boolean encontrada = listaAlmacen.contains(idDron);
        if (encontrada) {
            logger.info("El dron está en el almacén.");
            idDron.setReparar(1);
        } else {
            logger.error("El dron no está en el almacén");
            logger.info("Añadimos nuevo dron a reaparar, con id" + idDron);
            listaAlmacen.addLast(idDron);
        }
    }

    //Comprobar si el dron esta en el almacen, se repara y se saca de la listaAlmacen
    public void repararDron(Dron idDron){
        boolean encontrada = listaAlmacen.contains(idDron);

        if (encontrada) {
            logger.info("El dron se tiene que reparar.");
            idDron.setReparar(0);
            listaAlmacen.remove(idDron);
        } else {
            logger.error("El dron no está en el almacén. No se puede reparar.");
        }

    }


    //-------------AddReserva--------------------

    public void addReservaVuelo(String idDron, Date fecha, double duracion,
                                double posicionIni, double posicionFin, String idPiloto) {
        PlanVuelo planVuelo = null;
        logger.info("Comprobamos si ya existe el piloto con id " + idPiloto+"y el dron con id"+idDron);
        if (listPiloto.contains(idPiloto)) {
            logger.info("Piloto encontrado");
        }else{
            logger.error("El piloto no existe, se debe añadir primero");
        }
        if (listDron.contains(idDron)) {
            logger.info("Dron encontrado");
        }else{
            logger.error("El dron no existe, se debe añadir primero");
        }
        boolean encontrada = listaFechas.contains(fecha);
        //Considero que un piloto solo puede hacer un vuelo al dia, por lo tanto, busco en la lista
        // si el piloto ya tiene un vuelo asignado para esa fecha
        if (encontrada) {
            logger.error("El piloto ya tiene un vuelo asignado para esa fecha.");
        } else {
            logger.info("El piloto no tienen ningun vuelo. Fecha disponible");
            logger.info("Añadimos nuevo vuelo al piloto con id" + idPiloto);
            listaPlanVuelos= new LinkedList<PlanVuelo>();
            //Lo añadimos a la lista, ultimo elemento
            listaPlanVuelos.addLast(planVuelo);
        }

    }


    //-------------LISTAS------------------------
    //Lista de drones por horas de vuelo, ordenado descendentemente
    public LinkedList<Dron> dronesPorHorasVuelo() {
        List<Dron> list = listDron;
        list.sort((p1,p2)-> Double.compare(p1.getHorasVuelo(), p2.getHorasVuelo()));
        return (LinkedList<Dron>) list;
    }

    // Lista de pilotos por horas de vuelo, ordenado descendentemente
    public List<Piloto> pilotosPorHorasVuelo() {
        List<Piloto> list = listPiloto;
        list.sort((p1,p2)-> Double.compare(p1.getHorasVuelo(), p2.getHorasVuelo()));
        return list;
    }

    //Lista de planes de vuelo de un determinado piloto
    //Planteamiento: coger toda la lista y filtrar el id del piloto, y con las coincidencias hacer el listado
    public List<PlanVuelo> pilotoPlanVuelo(Piloto piloto) {
        String id = piloto.getId();
        return listaPlanVuelos.stream()
                .filter(pv -> pv.getIdPiloto().equals(id))
                .collect(Collectors.toList());
    }

    //Lista de planes de vuelo de un determinado dron
    //Planteamiento: coger toda la lista y filtrar el id del dron, y con las coincidencias hacer el listado
    public List<PlanVuelo> dronPlanVuelo(Dron dron) {
        String id = dron.getId();
        return listaPlanVuelos.stream()
                .filter(pv -> pv.getIdDron().equals(id))
                .collect(Collectors.toList());
    }


    public int numPilotos() {
        return this.listPiloto.size();
    }

    @Override
    public int numDrones() {
        return this.listDron.size();
    }

    @Override
    public int numPrilotos() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

}

