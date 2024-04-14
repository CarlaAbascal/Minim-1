package edu.upc.dsa.services;


import edu.upc.dsa.DronManager;
import edu.upc.dsa.DronManagerImpl;
import edu.upc.dsa.exceptions.dronExistente;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Root resource (exposed at "myresource" path)
 */
@Api(value = "/Drones", description = "Endpoint to Drones Service")
@Path("Drones")
public class DronService {

    private DronManager manager;

    public DronService()throws dronExistente {
        this.manager = DronManagerImpl.getManager();
        if (manager.size() == 0) {
            this.manager.addDron("1", "Dron1", "Fabricante1", "Modelo1");
            this.manager.addPiloto("1", "Carla", "Abascal");
        }
    }

    //------Añadir dron----
    @POST
    @ApiOperation(value = "Add new dron", notes = "Add new dron")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Dron.class),
            @ApiResponse(code = 500, message = "Validation Error")

            })


    @Path("/AddDron")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDron(Dron dron) throws dronExistente{

        if (dron.getId()==null || dron.getNombre()==null || dron.getFabricante()==null
                || dron.getModelo()==null) return Response.status(500).entity(dron).build();
        this.manager.addDron(dron.getId(), dron.getNombre(), dron.getFabricante(), dron.getModelo());
        return Response.status(201).entity(dron).build();
    }


    //------Añadir piloto----
    @POST
    @ApiOperation(value = "Add new piloto", notes = "Add new piloto")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Piloto.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/AddPiloto")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPiloto(Piloto piloto){

        if (piloto.getId()==null || piloto.getNombre()==null || piloto.getApellido()==null
        ) return Response.status(500).entity(piloto).build();
        this.manager.addPiloto(piloto.getId(), piloto.getNombre(), piloto.getApellido());
        return Response.status(201).entity(piloto).build();
    }

    //------Eliminar dron del almacen, ya ha sido reparado----
    @DELETE
    @ApiOperation(value = "Delete dron", notes = "Delete dron")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Dron.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/DeleteDron")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response repararDron(Dron dron){
        if (dron.getId()==null || dron.getNombre()==null || dron.getFabricante()==null
                || dron.getModelo()==null) return Response.status(500).entity(dron).build();
        this.manager.addDron(dron.getId(), dron.getNombre(), dron.getFabricante(), dron.getModelo());
        return Response.status(201).entity(dron).build();

    }
    //------Lista de horas de vuelo de un dron----
    @GET
    @ApiOperation(value = "Horas vuelo dron", notes = "Horas vuelo dron")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Dron.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/Horas Vuelo Dron")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response dronesPorHorasVuelo(Dron dron){
        if (dron.getId()==null || dron.getNombre()==null || dron.getFabricante()==null
                || dron.getModelo()==null) return Response.status(500).entity(dron).build();
        this.manager.addDron(dron.getId(), dron.getNombre(), dron.getFabricante(), dron.getModelo());
        return Response.status(201).entity(dron).build();

    }

    //------Lista de horas de vuelo de un piloto----
    @GET
    @ApiOperation(value = "Horas vuelo piloto", notes = "Horas vuelo piloto")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Piloto.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/Horas Vuelo Piloto")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response pilotosPorHorasVuelo(Piloto piloto){

        if (piloto.getId()==null || piloto.getNombre()==null || piloto.getApellido()==null
        ) return Response.status(500).entity(piloto).build();
        this.manager.addPiloto(piloto.getId(), piloto.getNombre(), piloto.getApellido());
        return Response.status(201).entity(piloto).build();
    }

    //------Añadir nueva reserva de vuelo----
/*
    @POST
    @ApiOperation(value = "Reservar vuelo", notes = "Reservar vuelo")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= PlanVuelo.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/AddPiloto")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addReservarVuelo(PlanVuelo pv){

        if (pv.getIdDron()==null || pv.getFecha()==null|| pv.getDuracion()==0|| pv.getPosicionIni()==0
                || pv.getPosicionFin()==0|| pv.getIdPiloto()==null
            )return Response.status(500).entity(pv).build();
        this.manager.addPiloto(pv.getIdDron(),pv.getDuracion(),pv.getIdPiloto());
        return Response.status(201).entity(pv).build();
    }

 */


}
